package p358;

import java.util.Arrays;
import java.util.Scanner;

public class CF358D {
    static int n;
    static int[] a, b, c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[][] dp = new long[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MIN_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + b[i - 1], dp[i - 1][1] + c[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][0] + a[i - 1], dp[i - 1][1] + b[i - 1]);
        }
        return String.valueOf(dp[n][1]);
    }
}
/*
D. Dima and Hares
https://codeforces.com/contest/358/problem/D

灵茶の试炼 2022-05-24
题目大意：
给你 3 个长度均为 n(<=3000) 的数组 a b c，元素范围 [0,1e5]，具体含义见下文。
有 n 个物品排成一排，你可以按照任意顺序拿物品，并获得相应的分数：
1. 如果拿走某个物品时，相邻两个物品都没有被拿过，那么得到的分数为 a[i]
2. 如果相邻的两个物品恰好有一个被拿过，那么得到的分数为 b[i]
3. 如果相邻的两个物品都被拿走了，那么得到的分数为 c[i]
问拿走所有物品后，能够获得的最高分数为多少？

rating 1800
https://www.luogu.com.cn/blog/littleseven/solution-cf358d
https://www.luogu.com.cn/problem/solution/CF358D
dp[i][1] 表示先选择 i-1，后选择 i，可以得到的前 i-1 的最大答案。
dp[i][0] 表示先选择 i，后选择 i-1，可以得到的前 i-1 的最大答案。
======

input
4
1 2 3 4
4 3 2 1
0 1 1 0
output
13

input
7
8 5 7 6 1 8 9
2 7 9 5 4 3 1
2 3 3 4 1 1 3
output
44

input
3
1 1 1
1 2 1
1 1 1
output
4
 */
