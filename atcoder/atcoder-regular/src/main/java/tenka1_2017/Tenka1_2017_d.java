package tenka1_2017;

import java.util.Scanner;

public class Tenka1_2017_d {
    static int n, k;
    static pair[] a;

    record pair(int v, int w) {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new pair[n];
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            a[i] = new pair(v, w);
        }
        System.out.println(solve());
    }

    private static String solve() {
        k++;
        int ban = 0;
        long ans = 0;
        for (int i = 30; i >= 0; i--) {
            if ((k >> i & 1) > 0) {
                ban ^= 1 << i;
                long s = 0;
                for (pair p : a) {
                    if ((p.v & ban) == 0) {
                        s += p.w;
                    }
                }
                ans = Math.max(ans, s);
            }
            ban ^= 1 << i;
        }
        return String.valueOf(ans);
    }
}
/*
D - IntegerotS
https://atcoder.jp/contests/tenka1-2017/tasks/tenka1_2017_d

灵茶の试炼 2025-02-12
题目大意：
输入 n(1≤n≤1e5) k(0≤k<2^30) 和 n 个 pair (ai,bi)，其中 0≤ai<2^30，1≤bi≤1e9。
从中选择一些 pair，满足所有 ai 的 OR <= k，并且 bi 之和越大越好。
输出 bi 之和的最大值。

和上周三（2.5）的题目一样，从高到低分析 k+1 的每一位：
如果是 1，那么如果 OR 的这一位是 0，右边所有比特位可以随便选，把所有这一位不是 1 的数的价值全部加起来，更新答案的最大值。
后续就只需考虑 OR 这一位是 1 的情况下的答案。
如果 k+1 这一位是 0，那么这一位是 1 的数就不能选（因为我们是从高到低考虑的）。
把哪些比特位不能选记录在一个变量 ban 中，所有与 ban 的 AND > 0 的数都不能选。
代码 https://atcoder.jp/contests/tenka1-2017/submissions/62443766
======

Input 1
3 5
3 3
4 4
2 5
Output 1
8

Input 2
3 6
3 3
4 4
2 5
Output 2
9

Input 3
7 14
10 5
7 4
11 4
9 8
3 6
6 2
8 9
Output 3
32
 */
