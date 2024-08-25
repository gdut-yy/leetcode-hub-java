package p1738;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1738C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static int[][][][] memo;

    private static String solve(int n, int[] a) {
        int[] cnt = new int[2];
        for (int x : a) {
            cnt[x & 1]++;
        }

        memo = new int[101][101][2][2];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 2; k++) {
                    Arrays.fill(memo[i][j][k], -1);
                }
            }
        }
        return dfs(cnt[0], cnt[1], 0, 0) == 1 ? "Alice" : "Bob";
    }

    // 奇数，偶数，Alice 的奇偶性，当前玩家
    private static int dfs(int i, int j, int odd, int who) {
        if (i == 0 && j == 0) {
            return odd ^ who ^ 1;
        }
        if (memo[i][j][odd][who] != -1) {
            return memo[i][j][odd][who];
        }
        int res = 0;
        if (i > 0 && dfs(i - 1, j, odd, who ^ 1) == 0 || j > 0 && dfs(i, j - 1, odd ^ who ^ 1, who ^ 1) == 0) {
            res = 1;
        }
        memo[i][j][odd][who] = res;
        return res;
    }
}
/*
C. Even Number Addicts
https://codeforces.com/contest/1738/problem/C

灵茶の试炼 2023-05-16
题目大意：
输入 T(≤100) 表示 T 组数据。
每组数据输入 n(1≤n≤100) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
Alice 和 Bob 轮流从 a 中取数，Alice 先。
游戏直到 a 为空时停止。
如果 Alice 所取数字之和为偶数，输出 Alice，否则输出 Bob。

rating 1500
https://codeforces.com/contest/1738/submission/205538013
提示：用记忆化搜索模拟。
f(leftEven, leftOdd, sum, who) 表示剩余偶数个数，剩余奇数个数，Alice 所选数字之和的奇偶性，当前玩家是 Alice 还是 Bob。
======

input
4
3
1 3 5
4
1 3 5 7
4
1 2 3 4
4
10 20 30 40
output
Alice
Alice
Bob
Alice
 */
