package p1983;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1983C {
    static int n;
    static long[][] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = new long[3][n + 1];
            for (int i = 0; i < 3; i++) {
                for (int j = 1; j <= n; j++) {
                    s[i][j] = scanner.nextInt();
                    s[i][j] += s[i][j - 1];
                }
            }
            System.out.println(solve());
        }
    }

    static int[][] perm3 = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0, 1}, {2, 1, 0}};

    private static String solve() {
        long tar = (s[0][n] + 2) / 3;
        for (int[] p : perm3) {
            int i = p[0], j = p[1], k = p[2];
            int l = searchInts(s[i], tar);
            int r = searchInts(s[k], s[0][n] - tar + 1) - 1;
            if (s[j][r] - s[j][l] >= tar) {
                int[] ans = new int[6];
                ans[i * 2] = 1;
                ans[i * 2 + 1] = l;
                ans[j * 2] = l + 1;
                ans[j * 2 + 1] = r;
                ans[k * 2] = r + 1;
                ans[k * 2 + 1] = n;
                return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            }
        }
        return "-1";
    }

    static int searchInts(long[] a, long key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
C. Have Your Cake and Eat It Too
https://codeforces.com/contest/1983/problem/C

灵茶の试炼 2024-09-23
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(3≤n≤2e5) 和三个长为 n 的数组 a b c，元素范围 [1,1e6]。
保证三个数组的元素和都等于 tot。
你需要找到三个不相交区间 [l1,r1], [l2,r2], [l3,r3]，满足
1. a 的 [l1,r1] 的子数组和 >= ceil(tot/3)。
2. b 的 [l2,r2] 的子数组和 >= ceil(tot/3)。
3. c 的 [l3,r3] 的子数组和 >= ceil(tot/3)。
输出任意满足要求的 l1,r1,l2,r2,l3,r3（下标从 1 开始）。如果无解，输出 -1。
注意三个区间没有位置顺序，例如 [l1,r1] 不一定在最左边。

rating 1400
贪心地想，必然有个数组要取最短前缀，满足元素和 >= ceil(tot/3)。
也必然有个数组要取最短后缀，满足元素和 >= ceil(tot/3)。
剩余的区间给到剩下的那个数组，如果子数组和 >= ceil(tot/3)，则找到一个方案。
枚举 3! = 6 种排列。
可以用前缀和优化。
代码 https://codeforces.com/contest/1983/submission/282485544
======

Input
10
5
5 1 1 1 1
1 1 5 1 1
1 1 1 1 5
6
1 2 3 4 5 6
5 6 1 2 3 4
3 4 5 6 1 2
4
4 4 4 4
4 4 4 4
4 4 4 4
5
5 10 5 2 10
9 6 9 7 1
10 7 10 2 3
3
4 5 2
6 1 4
1 8 2
3
10 4 10
8 7 9
10 4 10
7
57113 65383 19795 53580 74452 3879 23255
12917 16782 89147 93107 27365 15044 43095
33518 63581 33565 34112 46774 44151 41756
6
6 3 1 8 7 1
10 2 6 2 2 4
10 9 2 1 2 2
5
5 5 4 5 5
1 6 3 8 6
2 4 1 9 8
10
1 1 1 1 1001 1 1 1001 1 1
1 1 1 1 1 1 2001 1 1 1
1 1 1 1 1 1001 1 1 1 1001
Output
1 1 2 3 4 5
5 6 1 2 3 4
-1
-1
1 1 3 3 2 2
-1
1 2 3 4 5 7
3 6 1 1 2 2
1 2 3 4 5 5
1 5 6 7 8 10
 */