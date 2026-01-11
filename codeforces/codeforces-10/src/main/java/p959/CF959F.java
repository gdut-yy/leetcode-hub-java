package p959;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF959F {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int MOD = (int) (1e9 + 7);

    private static void solve() {
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        int[] a = new int[n];
        int[] pow2 = new int[n + 1];
        pow2[0] = 1;

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            pow2[i + 1] = (int) ((long) pow2[i] * 2 % MOD);
        }

        List<int[]>[] qs = new ArrayList[n];
        Arrays.setAll(qs, e -> new ArrayList<>());
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int x = scanner.nextInt();
            qs[l - 1].add(new int[]{x, i});
        }

        int[] ans = new int[q];
        XorBasis b = new XorBasis();

        for (int i = 0; i < n; i++) {
            int v = a[i];
            b.insert(v);
            for (int[] p : qs[i]) {
                int x = p[0];
                int idx = p[1];
                if (b.decompose(x)) {
                    ans[idx] = pow2[i + 1 - b.num];
                }
            }
        }

        for (int v : ans) {
            out.println(v);
        }
    }

    static class XorBasis {
        int[] b;
        int num;

        XorBasis() {
            b = new int[20];
            num = 0;
        }

        void insert(int v) {
            for (int i = b.length - 1; i >= 0; i--) {
                if ((v >> i & 1) == 0) {
                    continue;
                }
                if (b[i] == 0) {
                    b[i] = v;
                    num++;
                    return;
                }
                v ^= b[i];
            }
        }

        boolean decompose(int v) {
            for (int i = b.length - 1; i >= 0; i--) {
                if ((v >> i & 1) > 0) {
                    if (b[i] == 0) {
                        return false;
                    }
                    v ^= b[i];
                }
            }
            return true;
        }
    }
}
/*
F. Mahmoud and Ehab and yet another xor task
https://codeforces.com/contest/959/problem/F

灵茶の试炼 2025-08-01
题目大意：
输入 n(1≤n≤1e5) q(1≤q≤1e5) 和长为 n 的数组 a(0≤a[i]<2^20)。下标从 1 开始。
然后输入 q 个询问，每个询问输入 i(1≤i≤n) 和 x(1≤x<2^20)。
对于每个询问，输出 a 的前 i 个数（下标 1 到 i）中的子序列个数，满足子序列的异或和恰好等于 x。
答案模 1e9+7。
注：子序列不一定连续。

rating 2400
离线询问。
遍历 a，维护前 i 个数的线性基。
遍历到 a[i] 时，回答对应的询问。
设现在有 num 个基，那么 x 被这些基表出的方案是唯一的（因为基的二进制长度互不相同）。对应到原数组上，在前 i 个数中，有 num 个数可以确定是一定选还是一定不选。
对于其余的 i-num 个数，就可以随便选或不选了，为什么呢？
在其余的 i-num 个数中，如果选了某个数 v，那么我们可以「反选」表出 v 的那些基，从而做到异或和 x 不变。其中「反选」的意思是如果原来选了，那么不选，如果原来不选，那么选。
相当于把前 i 个数分成两组，第一组视作 num 个灯泡，第二组视作 i-num 个开关。这些开关可以随意拨动，控制某些灯的亮灭。无论如何拨动开关，亮着的灯和拨动的开关（表示我们选的元素）的异或和总可以是 x。
因此答案为 pow(2, i-num)。用快速幂计算，或值预处理 2 的幂。
下面代码下标从 0 开始，写的是 i+1-num。
代码 https://codeforces.com/contest/959/submission/245572221
代码备份（Ubuntu Pastebin）
======

Input
5 5
0 1 2 3 4
4 3
2 0
3 7
5 7
5 8
Output
4
2
0
4
0

Input
3 2
1 1 1
3 1
2 0
Output
4
2
 */
