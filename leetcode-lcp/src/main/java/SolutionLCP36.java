import java.util.Arrays;

public class SolutionLCP36 {
    // CF1110D
    // https://leetcode.cn/problems/Up5XYM/solution/pyon-o1fan-yi-yi-xia-touristde-dai-ma-by-y4q4/
    // https://codeforces.com/contest/1110/submission/49574216
    // lc1363
    // https://leetcode.cn/problems/Up5XYM/solution/lcp-36-zui-duo-pai-zu-shu-by-zerotrac2-vt8g/
    public int maxGroupNumber(int[] tiles) {
        Arrays.sort(tiles);
        int n = tiles.length;

        int[][][][] f = new int[n][5][5][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    Arrays.fill(f[i][j][k], -1);
                }
            }
        }
        f[0][0][0][1] = 0;

        for (int i = 1; i < n; i++) {
            for (int a = 0; a < 5; a++) {
                for (int b = 0; b < 5; b++) {
                    for (int c = 0; c < 5; c++) {
                        if (f[i - 1][a][b][c] == -1) {
                            continue;
                        }
                        if (tiles[i - 1] == tiles[i]) {
                            f[i][a][b][c] = Math.max(f[i][a][b][c], f[i - 1][a][b][c]);
                            if (c != 4) {
                                f[i][a][b][c + 1] = Math.max(f[i][a][b][c + 1], f[i - 1][a][b][c]);
                            }
                            if (c + 1 >= 3) {
                                f[i][a][b][c - 2] = Math.max(f[i][a][b][c - 2], f[i - 1][a][b][c] + 1);
                            }
                            if (Math.min(a, Math.min(b, c + 1)) >= 1) {
                                f[i][a - 1][b - 1][c] = Math.max(f[i][a - 1][b - 1][c], f[i - 1][a][b][c] + 1);
                            }
                        } else if (tiles[i - 1] + 1 == tiles[i]) {
                            f[i][b][c][1] = Math.max(f[i][b][c][1], f[i - 1][a][b][c]);
                            if (Math.min(b, c) >= 1) {
                                f[i][b - 1][c - 1][0] = Math.max(f[i][b - 1][c - 1][0], f[i - 1][a][b][c] + 1);
                            }
                        } else if (tiles[i - 1] + 2 == tiles[i]) {
                            f[i][c][0][1] = Math.max(f[i][c][0][1], f[i - 1][a][b][c]);
                        } else {
                            f[i][0][0][1] = Math.max(f[i][0][0][1], f[i - 1][a][b][c]);
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                for (int c = 0; c < 5; c++) {
                    ans = Math.max(ans, f[n - 1][a][b][c]);
                }
            }
        }
        return ans;
    }
}
/*
LCP 36. 最多牌组数
https://leetcode.cn/problems/Up5XYM/

麻将的游戏规则中，共有两种方式凑成「一组牌」：
- 顺子：三张牌面数字连续的麻将，例如 [4,5,6]
- 刻子：三张牌面数字相同的麻将，例如 [10,10,10]
给定若干数字作为麻将牌的数值（记作一维数组 tiles），请返回所给 tiles 最多可组成的牌组数。
注意：凑成牌组时，每张牌仅能使用一次。
提示：
1 <= tiles.length <= 10^5
1 <= tiles[i] <= 10^9
 */