package p1196;

import java.util.Scanner;

public class CF1196D2 {
    static int n, k;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = n;
        int[][] dp = new int[n + 1][3];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = new int[]{dp[i][2] + 1, dp[i][0] + 1, dp[i][1] + 1};
            dp[i + 1][mp(s[i])]--;
            if (i + 1 >= k) {
                for (int j = 0; j < 3; j++) {
                    ans = Math.min(ans, dp[i + 1][j] - dp[i + 1 - k][(j + 3 - k % 3) % 3]);
                }
            }
        }
        return String.valueOf(ans);
    }

    static int mp(char c) {
        if (c == 'R') return 0;
        else if (c == 'G') return 1;
        return 2;
    }
}
/*
D2. RGB Substring (hard version)
https://codeforces.com/contest/1196/problem/D2

灵茶の试炼 2022-07-21
题目大意：
输入 t(<=2e5)，表示有 t 组数据。
每组数据输入 n 和 k（1<=k<=n<=2e5)，和一个长为 n 的字符串 s，包含 RGB 三种字符。
输出至少修改 s 的多少个字符，可以使 s 中存在一个长度至少为 k 的 RGB 子串。
RGB 子串指无限长字符串 RGBRGBRGB... 的子串。
输入保证这 t 组数据的 n 的和不超过 2e5。

rating 1600
https://codeforces.com/contest/1196/submission/118029732
枚举把 s 修改成 RGBRGB.../GBRGBR.../BRGBRG...，然后做一个大小为 k 的滑窗即可。
======

input
3
5 2
BGGGG
5 3
RBRGR
5 5
BBBRR
output
1
0
3
 */