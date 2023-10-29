package p1881;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1881C {
    static int n;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new char[n][n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.next().toCharArray();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[][] arr0 = new int[n][n];
        int[][] arr90 = new int[n][n];
        int[][] arr180 = new int[n][n];
        int[][] arr270 = new int[n][n];
        int id = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr0[i][j] = id;
                arr90[i][j] = id;
                arr180[i][j] = id;
                arr270[i][j] = id;
                id++;
            }
        }
        rotate(arr90);
        rotate(arr180);
        rotate(arr180);
        rotate(arr270);
        rotate(arr270);
        rotate(arr270);

        int ans = 0;
        boolean[] vis = new boolean[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[arr0[i][j]]) {
                    vis[arr0[i][j]] = true;
                    vis[arr90[i][j]] = true;
                    vis[arr180[i][j]] = true;
                    vis[arr270[i][j]] = true;

                    int x1 = arr90[i][j] / n, y1 = arr90[i][j] % n;
                    int x2 = arr180[i][j] / n, y2 = arr180[i][j] % n;
                    int x3 = arr270[i][j] / n, y3 = arr270[i][j] % n;
                    char[] cs = new char[]{a[i][j], a[x1][y1], a[x2][y2], a[x3][y3]};
                    Arrays.sort(cs);
                    for (int k = 0; k < 3; k++) {
                        ans += cs[3] - cs[k];
                    }
                }
            }
        }
        return String.valueOf(ans);
    }

    private static void rotate(int[][] b) {
        // 上下翻转
        for (int i = 0; i < n / 2; i++) {
            int[] tmp = b[i];
            b[i] = b[n - 1 - i];
            b[n - 1 - i] = tmp;
        }
        // 对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = b[i][j];
                b[i][j] = b[j][i];
                b[j][i] = tmp;
            }
        }
    }
}
/*
C. Perfect Square
https://codeforces.com/contest/1881/problem/C

题目大意：
克里斯汀娜有一个 n × n 大小的矩阵，里面都是小写的拉丁字母。n 的值是偶数。
她想改变一些字符，使她的矩阵成为一个完全的平方。如果一个矩阵在顺时针旋转 90° 时保持不变，就称为完全正方形。
下面是将一个矩阵旋转 90° 的例子:
在一个操作中，Kristina 可以选择任何单元格并用字母表中的下一个字符替换其值。如果字符等于“z”，则其值不变。
求出使矩阵成为完全平方所需要的最小运算次数。
例如，如果 4 × 4 矩阵是这样的:
那么对字母 b 应用 1 个操作就足够了，以粗体突出显示。

贪心，4个格子为一组，调整到最大值的操作数 的和即为答案。
======

input
5
4
abba
bcbb
bccb
abba
2
ab
ba
6
codefo
rcesco
deforc
escode
forces
codefo
4
baaa
abba
baba
baab
4
bbaa
abba
aaba
abba
output
1
2
181
5
9
 */
