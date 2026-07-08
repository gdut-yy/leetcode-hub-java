package p2180;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF2180C {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[k];
        Arrays.fill(a, n);
        if (k % 2 == 0) {
            int free = 0;
            for (int i = bitsLen(n) - 1; i >= 0; i--) {
                if (((n >> i) & 1) > 0) {
                    a[Math.min(free, k - 1)] ^= 1 << i;
                    free++;
                } else {
                    for (int j = 0; j < Math.min(free & ~1, k); j++) {
                        a[j] |= 1 << i;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int v : a) {
            sb.append(v).append(" ");
        }
        out.println(sb);
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
C. XOR-factorization
https://codeforces.com/contest/2180/problem/C

灵茶の试炼 2026-02-05
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 k 之和 ≤1e5。
每组数据输入 n(1≤n≤1e9) 和 k(1≤k≤1e5)。
构造一个长为 k 的数组 a，满足：
1. 0 ≤ a[i] ≤ n。
2. XOR(a) = n（即 a 中所有元素的异或和等于 n）。
3. sum(a) 最大。
输出 a。
多解输出任意解。

rating 1900
如果 k 是奇数，那么答案就是理论最大值：k 个 n。（a[i] 最大是 n）
如果 k 是偶数呢？
可以先初始化 a = [n,n,...,n]（k 个 n），然后在此基础上微调。
n 的最高位是 1，所以必须把一个 a[i] 的最高位改成 0。不妨改 a[0]。
注意，a[0] 最高位变成 0 后，其余低位可以随便填。这有什么好处？对于 n 中的比特 0，我们可以填偶数个 1，这些 1 只能来自这种「可以随便填」的数。
如果 n 是次高位也是 1，那么也得把一个 a[i] 的次高位改成 0，改哪个数好呢？
如果也改 a[0]，那就浪费了一次可以再把一个数变成「可以随便填」的数的机会，所以选择把 a[1] 的次高位改成 0，这样「可以随便填」的数就增加了一个。
一般地，当 k 是偶数时，构造方案如下：
初始化 a = [n,n,...,n]。
初始化「可以随便填」的数的个数 free = 0。
从高到低遍历 n 的比特位：
如果这一位是 1，那么把 a[min(free, k-1)] 的这一位改成 0，然后把 free 增加 1。
如果这一位是 0，那么 a 的前 min(free-free%2, k) 个数可以是 1。注意如果 free 是奇数，要减一，调整为偶数。
时间复杂度：O(k + log²(n))。如果只要求输出 sum(a) 的话，可以做到 O(log n)。
代码 https://codeforces.com/contest/2180/submission/361420118
代码备份（上面打不开的同学看这个）
======

Input
4
5 4
4 3
8 2
1 1
Output
1 4 5 5
4 4 4
0 8
1
 */
