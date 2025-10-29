package p348;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF348C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int B = (int) Math.sqrt(3e5);
        int[][] sets = new int[m][];
        int[] iToBig = new int[m];
        List<Long> bigSum = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int k = scanner.nextInt();
            sets[i] = new int[k];
            long s = 0;
            for (int j = 0; j < k; j++) {
                int num_ij = scanner.nextInt() - 1;
                sets[i][j] = num_ij;
                s += a[num_ij];
            }
            if (k > B) {
                bigSum.add(s);
                iToBig[i] = bigSum.size();
            }
        }

        int nb = bigSum.size();
        int[][] intersectionSize = new int[m][nb];
        boolean[] has = new boolean[n];
        int cur = 0;

        for (int[] big : sets) {
            if (big.length <= B) continue;
            for (int j : big) {
                has[j] = true;
            }
            for (int i = 0; i < sets.length; i++) {
                int[] st = sets[i];
                for (int j : st) {
                    if (has[j]) {
                        intersectionSize[i][cur]++;
                    }
                }
            }
            cur++;
            for (int j : big) {
                has[j] = false;
            }
        }

        long[] bigTodo = new long[nb];
        while (q-- > 0) {
            String op = scanner.next();
            int k = scanner.nextInt() - 1;
            int[] st = sets[k];
            if (op.equals("+")) {
                int x = scanner.nextInt();
                if (st.length > B) {
                    bigTodo[iToBig[k] - 1] += x;
                } else {
                    for (int i : st) {
                        a[i] += x;
                    }
                    for (int j = 0; j < nb; j++) {
                        bigSum.set(j, bigSum.get(j) + (long) x * intersectionSize[k][j]);
                    }
                }
            } else {
                long s = 0;
                if (st.length > B) {
                    s = bigSum.get(iToBig[k] - 1);
                } else {
                    for (int i : st) {
                        s += a[i];
                    }
                }
                for (int j = 0; j < nb; j++) {
                    s += bigTodo[j] * intersectionSize[k][j];
                }
                out.println(s);
            }
        }
    }
}
/*
C. Subset Sums
https://codeforces.com/contest/348/problem/C

灵茶の试炼 2025-08-22
题目大意：
输入 n m q(1≤n,m,q≤1e5) 和长为 n 的数组 a(-1e8≤a[i]≤1e8)。
然后输入 m 个下标集合：对于每个集合，首先输入集合大小 k，然后输入 k 个互不相同的 [1,n] 中的下标。保证所有集合的大小之和 ≤1e5。
然后输入 q 个询问，格式如下：
"+ k x"：把第 k(1≤k≤m) 个下标集合中的 a[i] 都增加 x(-1e8≤x≤1e8)。
"? k"：输出第 k(1≤k≤m) 个下标集合中的 a[i] 之和。
注：如果两个集合 A 和 B 有交集，那么增加集合 A 的 a[i]，会影响集合 B 的 a[i] 之和。

rating 2500
关键思路：
1. 用 lazy tag 标记每个大集合需要增加的量。
2. 对于每个集合 S，预处理 S 与每个大集合的【交集大小】。
具体来说：
对于每个大集合 S，维护对应的元素和 bigSum，初始为 sum(a[i] for i in S)。小集合无需维护，直接暴力算。
1. "+" 大集合 S：只需把 S 的 lazy tag 增加 x。不改 bigSum。
2. "+" 小集合 S：对于 S 中的 i，暴力更新对应的 a[i] += x。此外，把每个大集合 T 的 bigSum 增加 S 与 T 的交集大小 * x。
3. "?" 大集合 S：答案为 bigSum + 遍历每个大集合 T，计算 S 与 T 的交集大小 * lazy tag。
4. "?" 小集合 S：答案为 sum(a[i] for i in S) + 遍历每个大集合 T，计算 S 与 T 的交集大小 * lazy tag。
多大的集合算作大集合？阈值 B 取多少？
处理每个询问需要 O(B + L/B) 时间。其中 L<=1e5，即所有集合的大小之和。
B 取 sqrt(L) 比较均衡。
然而，考虑到处理大集合相比暴力处理小集合要麻烦一些，实测 B 取 sqrt(2L) ~ sqrt(4L) 更快。
时间复杂度（主项）：O(q*sqrt(L))。处理每个询问需要 O(sqrt(L))。
空间复杂度（主项）：O(m*sqrt(L))。预处理交集大小的所需空间。
代码 https://codeforces.com/contest/348/submission/334494899
代码备份（上面打不开的同学看这个）
======

Input
5 3 5
5 -5 5 1 -4
2 1 2
4 2 1 4 5
2 2 5
? 2
+ 3 4
? 1
+ 2 1
? 2
Output
-3
4
9
 */
