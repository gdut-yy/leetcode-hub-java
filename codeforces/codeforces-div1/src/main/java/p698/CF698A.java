package p698;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF698A {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static int[][] memo;

    private static String solve() {
        memo = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        int ans = dfs(0, 0);
        return String.valueOf(ans);
    }

    // j=0,1,2 休息,比赛,健身
    private static int dfs(int i, int j) {
        if (i == n) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // 休息
        int res = dfs(i + 1, 0) + 1;
        if (j == 0) {
            if (a[i] == 1) res = Math.min(res, dfs(i + 1, 1));
            else if (a[i] == 2) res = Math.min(res, dfs(i + 1, 2));
            else if (a[i] == 3) res = Math.min(res, Math.min(dfs(i + 1, 1), dfs(i + 1, 2)));
        } else if (j == 1) {
            // 健身
            if (a[i] == 2 || a[i] == 3) res = Math.min(res, dfs(i + 1, 2));
        } else if (j == 2) {
            // 比赛
            if (a[i] == 1 || a[i] == 3) res = Math.min(res, dfs(i + 1, 1));
        }
        return memo[i][j] = res;
    }
}
/*
A. Vacations
https://codeforces.com/contest/698/problem/A

灵茶の试炼 2023-07-10
题目大意：
输入 n(1≤n≤100) 和长为 n 的数组 a(0≤a[i]≤3)。
有 n 天，第 i 天的情况用 a[i]=0/1/2/3 表示，具体如下：
0：健身房关闭，比赛不进行；
1：健身房关闭，比赛进行；
2：健身房开放，比赛不进行；
3：健身房开放，比赛进行。
在每一天，你可以休息、比赛 (如果比赛在这一天进行)，或者做运动 (如果健身房在这一天是开放的)。
但你不想连续两天做同样的活动，这意味着，你不会连续两天做运动，也不会连续两天参加比赛。
输出你休息的最少天数。

https://codeforces.com/problemset/submission/698/213038992
状态机 DP。
定义 f[i+1][0/1/2] 表示前 i 天最少休息天数，其中第 i 天 休息/比赛/健身。
初始值 f[0][j] = 0。
转移：
f[i+1][0] = min(f[i]) + 1
如果 a[i]=1或3，f[i+1][1] = min(f[i][0], f[i][2]) 否则 f[i+1][1] = inf
如果 a[i]=2或3，f[i+1][2] = min(f[i][0], f[i][1]) 否则 f[i+1][2] = inf
答案为 min(f[n])。
代码实现时可以滚动。
======

input
4
1 3 2 0
output
2

input
7
1 3 3 2 1 2 3
output
0

input
2
2 2
output
1
 */
