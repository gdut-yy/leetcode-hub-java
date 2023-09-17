package c302;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc302_b {
    private static int h, w;
    private static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        h = scanner.nextInt();
        w = scanner.nextInt();
        a = new char[h][w];
        for (int i = 0; i < h; i++) {
            a[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static final int[][] DIRECTIONS8 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    private static String solve() {
        // s, n, u, k, and e
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (a[i][j] == 's') {
                    for (int[] dir : DIRECTIONS8) {
                        if (check(i, j, dir)) {
                            return (1 + i) + " " + (1 + j)
                                    + System.lineSeparator() + (1 + i + dir[0]) + " " + (1 + j + dir[1])
                                    + System.lineSeparator() + (1 + i + dir[0] * 2) + " " + (1 + j + dir[1] * 2)
                                    + System.lineSeparator() + (1 + i + dir[0] * 3) + " " + (1 + j + dir[1] * 3)
                                    + System.lineSeparator() + (1 + i + dir[0] * 4) + " " + (1 + j + dir[1] * 4);
                        }
                    }
                }
            }
        }
        return "-1";
    }

    private static boolean check(int x, int y, int[] dir) {
        int nx = x + dir[0] * 4;
        int ny = y + dir[1] * 4;
        if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
            return a[x + dir[0]][y + dir[1]] == 'n'
                    && a[x + dir[0] * 2][y + dir[1] * 2] == 'u'
                    && a[x + dir[0] * 3][y + dir[1] * 3] == 'k'
                    && a[x + dir[0] * 4][y + dir[1] * 4] == 'e';
        }
        return false;
    }
}
/*
B - Find snuke
https://atcoder.jp/contests/abc302/tasks/abc302_b

题目大意：
有一个有 H 横行和 W 纵列的网格。每个单元格上都写着一个小写的英文字母。我们用(i,j)表示从上面算起第 i 行，从左边算起第 j 列的单元格。
写在网格上的字母由长度为 w 的 H 字符串 s1, s2，…，S H 表示。S i 的第 j 个字母表示写在(i,j)上的字母。
网格中有一组独特的连续单元格(垂直、水平或对角线)，其中 s、n、u、k 和 e 按此顺序写入。查找这些单元格的位置，并以 Output 部分中指定的格式打印它们。
当且仅当满足以下所有条件时，五个单元格(a1, a2, a3, a4, a5)的元组被称为形成一组连续单元格(垂直，水平或对角线)，其中 s, n, u, k 和 e 按此顺序写入。
- a1、a2、a3、a4 和 a5 上分别写着字母 s、n、u、k 和 e。
- 对于所有 1≤i≤4，单元格 ai 和 ai +1 共用一个角或一条边。
- a1、a2、a3、a4 和 a5 的中心每隔一定的间隔在同一条直线上。

暴力。
======

Input 1
6 6
vgxgpu
amkxks
zhkbpp
hykink
esnuke
zplvfj
Output 1
5 2
5 3
5 4
5 5
5 6

Input 2
5 5
ezzzz
zkzzz
ezuzs
zzznz
zzzzs
Output 2
5 5
4 4
3 3
2 2
1 1

Input 3
10 10
kseeusenuk
usesenesnn
kskekeeses
nesnusnkkn
snenuuenke
kukknkeuss
neunnennue
sknuessuku
nksneekknk
neeeuknenk
Output 3
9 3
8 3
7 3
6 3
5 3
 */