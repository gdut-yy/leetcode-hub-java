package nc60456;

import java.util.Arrays;
import java.util.Scanner;

public class NC60456B {
    static int n;
    static int[] a;
    static char[] cs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        cs = scanner.next().toCharArray();
        System.out.println(solve());
    }

    static long[][] memo;

    private static String solve() {
        memo = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        long ans = dfs(0, 0);
        return String.valueOf(ans);
    }

    // j:0 没选, 1 选了
    private static long dfs(int i, int j) {
        if (i == n - 1) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // 不选
        long res = dfs(i + 1, 0);
        // 选
        if (j == 0) {
            if (cs[i] != cs[i + 1]) {
                res = Math.max(res, dfs(i + 1, 1) + a[i] + a[i + 1]);
            }
        }
        return memo[i][j] = res;
    }
}
/*
相邻不同数字的标记
https://ac.nowcoder.com/acm/contest/60456/B

题目描述
小红拿到了一个数组，每个数字被染成了红色或蓝色。
小红有很多次操作，每次操作可以选择两个相邻的不同颜色的数字标记，并获得它们数字之和的得分。已经被标记的数字无法再次标记。
小红想知道，自己最多能获得多少分。
输入描述:
第一行输入一个正整数 n ，代表数组的长度。
第二行输入 n 个正整数 ai，代表小红拿到的数组。
第三行输入一个仅包含 'R' 和 'B' 的字符串，第 i 个字符为 'R' 代表数组第 i 个数被染成红色，'B'代表被染成蓝色。
1≤n≤10^5
1≤ai≤10^9
输出描述:
输出一个整数，表示小红最多能获得的分值。

记忆化搜索
======

示例1
输入
5
1 3 2 6 5
BRRBB
输出
12
说明
第一次选择标记第一个数和第二个数，标记的数是1和3。
第二次选择标记第三个数和第四个数，标记的数是2和6。
总得分为1+3+2+6=12
 */