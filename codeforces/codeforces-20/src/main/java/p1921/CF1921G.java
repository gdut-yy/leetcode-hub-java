package p1921;

import java.util.Scanner;

public class CF1921G {
    static int n, m, k;
    static char[][] cs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            k = scanner.nextInt();
            cs = new char[n][m];
            for (int i = 0; i < n; i++) {
                cs[i] = scanner.next().toCharArray();
            }
            System.out.println(solve());
        }
    }

    static int[][] a;

    private static String solve() {
        k++;
        a = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = (cs[i][j] == '#' ? 1 : 0);
            }
        }
        long mx = ans();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = (cs[n - i - 1][j] == '#' ? 1 : 0);
            }
        }
        mx = Math.max(mx, ans());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = (cs[i][m - j - 1] == '#' ? 1 : 0);
            }
        }
        mx = Math.max(mx, ans());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = (cs[n - i - 1][m - j - 1] == '#' ? 1 : 0);
            }
        }
        mx = Math.max(mx, ans());

        return String.valueOf(mx);
    }

    static long ans() {
        long cnt = 0;
        long[][] dp = new long[n][m];
        long[][] pref = new long[n][m];
        long[][] pref_up = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pref_up[i][j] = a[i][j];
                if (prov(i - 1, j)) {
                    pref_up[i][j] += pref_up[i - 1][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                pref[i][j] = a[i][j];
                if (prov(i - 1, j + 1)) {
                    pref[i][j] += pref[i - 1][j + 1];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = pref_up[i][j];
                if (prov(i - k, j)) {
                    dp[i][j] -= pref_up[i - k][j];
                }
                if (prov(i, j - 1)) {
                    dp[i][j] += dp[i][j - 1];
                }
                if (j < k) {
                    int i1 = j - k + i;
                    if (i1 >= 0) {
                        dp[i][j] -= pref[i1][0];
                    }
                } else {
                    dp[i][j] -= pref[i][j - k];
                }
                if (prov(i - k, j)) {
                    dp[i][j] += pref[i - k][j];
                }
                cnt = Math.max(cnt, dp[i][j]);
            }
        }

        return cnt;
    }

    static boolean prov(int i, int j) {
        return 0 <= i && i < n && 0 <= j && j < m;
    }
}
/*
G. Mischievous Shooter
https://codeforces.com/contest/1921/problem/G

题目大意：
有一次，顽皮任性的射手谢尔发现自己站在一个矩形场地上，场地大小为 n×m，分为正方形。每个单元格要么包含目标，要么不包含目标。
谢尔只有一把幸运猎枪，他可以从四个方向射击:右向下、左向下、左向上或右向上。射击时，霰弹枪击中选定方向的所有目标，曼哈顿距离不超过一个固定常数 k。两点(x1,y1)和(x2,y2)之间的曼哈顿距离等于|x1−x2|+|y1−y2|。
壳牌的目标是击中尽可能多的目标。请帮他找到这个值。

rating 2200
https://codeforces.com/blog/entry/124757
首先，请注意，我们只能考虑受影响细胞的三角形是向左上的情况。为了解决剩下的情况，我们可以解决四种不同的棋盘方向的问题，并从得到的结果中选择最大的结果。
我们将存储几个带有前缀和的数组:用于存储给定列上方当前列单元格中所有数字的和，以及用于存储给定列上方和右侧单元格中所有数字的和。使用这样的前缀和，我们可以很容易地通过 O(1)中 cell (i,j−1)中的答案重新计算 cell (i,j)中的答案。为此，我们需要将标记为绿色的单元格的总和相加，并减去标记为红色的单元格的总和。
该解的总时间复杂度为 0 (nm)。
注意，这个问题也可以在 O(nmmin(n,m))时间内解决，方法是在最小方向上计算前缀和，在 O(min(n,m))时间内计算三角形的和。这个解决方案也符合时间限制。
======

input
4
3 3 1
.#.
###
.#.
2 5 3
###..
...##
4 4 2
..##
###.
#..#
####
2 1 3
#
#
output
3
4
5
2
 */