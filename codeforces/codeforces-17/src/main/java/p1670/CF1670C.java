package p1670;

import java.util.Scanner;

public class CF1670C {
    static int n;
    static int[] a, to;
    static boolean[] has;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            to = new int[n + 1];
            for (int v : a) {
                to[v] = scanner.nextInt();
            }
            has = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                int v = scanner.nextInt();
                has[v] = true;
            }
            System.out.println(solve());
        }
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        long ans = 1;
        boolean[] vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            boolean allZero = !has[i];
            for (int x = to[i]; x != i; x = to[x]) {
                vis[x] = true;
                if (has[x]) {
                    allZero = false;
                }
            }
            if (allZero && i != to[i]) {
                ans = ans * 2 % MOD;
            }
        }
        return String.valueOf(ans);
    }
}
/*
C. Where is the Pizza?
https://codeforces.com/contest/1670/problem/C

灵茶の试炼 2024-07-09
题目大意：
输入 T(≤1e5) 表示 T 组数据。所有数据的 n 之和 ≤5e5。
每组数据输入 n(1≤n≤1e5) 和两个 1~n 的排列 a 和 b，
然后输入数组 d，保证 d[i] 是 {0,a[i],b[i]} 中的一个。
构造一个 1~n 的排列 c，满足：
如果 d[i]>0，那么 c[i] 必须是 d[i]，否则 c[i] 可以是 a[i]，也可以是 b[i]。
你能构造出多少个不同的排列 c？模 1e9+7。
输入保证至少能构造一个排列 c。

rating 1400
从 a[i] 向 b[i] 连边，我们会得到若干个环（没有树枝，因为 a 和 b 都是排列）。
对于长度大于 1 的环，如果不包含 d[i] > 0 的点，那么有两种选法。比如 1-2-3-1 这个环，每条边可以分别选 1,2,3 也可以分别选 2,3,1。
所以答案就是 2^m，其中 m 是长度大于 1 的不含 d[i]>0 的环的个数。
代码 https://codeforces.com/contest/1670/submission/240100771
======

Input
9
7
1 2 3 4 5 6 7
2 3 1 7 6 5 4
2 0 1 0 0 0 0
1
1
1
0
6
1 5 2 4 6 3
6 5 3 1 4 2
6 0 0 0 0 0
8
1 6 4 7 2 3 8 5
3 2 8 1 4 5 6 7
1 0 0 7 0 3 0 5
10
1 8 6 2 4 7 9 3 10 5
1 9 2 3 4 10 8 6 7 5
1 9 2 3 4 10 8 6 7 5
7
1 2 3 4 5 6 7
2 3 1 7 6 5 4
0 0 0 0 0 0 0
5
1 2 3 4 5
1 2 3 4 5
0 0 0 0 0
5
1 2 3 4 5
1 2 3 5 4
0 0 0 0 0
3
1 2 3
3 1 2
0 0 0
Output
4
1
2
2
1
8
1
2
2
 */
