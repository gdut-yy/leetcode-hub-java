package c300;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc300_c {
    private static int h, w;
    private static char[][] c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        h = scanner.nextInt();
        w = scanner.nextInt();
        c = new char[h][w];
        for (int i = 0; i < h; i++) {
            c[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    // 左下 右上 左上 右下
    private static final int[][] DIRECTIONS4 = {{-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    private static String solve() {
        int n = Math.min(h, w);
        int[] ans = new int[n];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (c[i][j] != '#') continue;
                if (test(i, j, 1)) {
                    int d = 1;
                    while (test(i, j, d + 1)) {
                        d++;
                    }
                    ans[d - 1]++;
                }
            }
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    private static boolean test(int i, int j, int d) {
        for (int[] dir : DIRECTIONS4) {
            int nx = i + dir[0] * d;
            int ny = j + dir[1] * d;
            if (nx < 0 || nx >= h || ny < 0 || ny >= w || c[nx][ny] != '#') {
                return false;
            }
        }
        return true;
    }
}
/*
C - Cross
https://atcoder.jp/contests/abc300/tasks/abc300_c

题目大意：
我们有一个有 H 横行和 W 纵列的网格。我们用(i,j)表示网格顶部第 i 列和左侧第 j 列的单元格。
网格中的每个单元格都有一个符号 # or . 写在上面。设 C[i][j]为(i,j)上的字符。对于整数 i 和 j，满足 1≤i≤H 和 1≤j≤W 中至少有一个不成立，定义 C[i][j]为 .
由 (a,b) 和 (a+d,b+d), (a+d,b-d), (a-d,b+d), (a-d,b+d), (a-d,b-d) (1≤d≤n,1≤n) 组成的 (4n+1) 个正方形被称为以(a,b)为中心的大小为 n 的十字，当且仅当满足以下所有条件:
- C[a][b]是 #。
- C[a+d][b+d], C[a+d][b−d], C[a−d][b+d] 和 C[a−d][b−d] 都是 #,为所有整数维 1≤d≤n,
- 至少一个 C[a+n+1][b+n+1], C[a+n+1][b-n−1], C[a-n−1][b+n+1], C[a-n−1][b-n−1] 为 .
例如，下图中的网格有一个以(2,2)为中心的大小为 1 的十字，另一个以(3,7)为中心的大小为 2 的十字。
网格上有一些叉。单元格上没有写#，除了那些组成十字架的单元格。
此外，由两个不同的十字架组成的两个正方形不能共用一个角。下图中的两个网格是包含不同十字的两个正方形共用一个角的网格的示例;这样的网格不作为输入给出。例如，左边的网格是无效的，因为(3,3)和(4,4)共用一个角。
设 N=min(H,W)， sn 为大小为 N 的十字的个数。求 s1, s2,..., sn。
======

Input
5 9
#.#.#...#
.#...#.#.
#.#...#..
.....#.#.
....#...#
Output
1 1 0 0 0

Input
3 3
...
...
...
Output
0 0 0

Input
3 16
#.#.....#.#..#.#
.#.......#....#.
#.#.....#.#..#.#
Output
3 0 0

Input
15 20
#.#..#.............#
.#....#....#.#....#.
#.#....#....#....#..
........#..#.#..#...
#.....#..#.....#....
.#...#....#...#..#.#
..#.#......#.#....#.
...#........#....#.#
..#.#......#.#......
.#...#....#...#.....
#.....#..#.....#....
........#.......#...
#.#....#....#.#..#..
.#....#......#....#.
#.#..#......#.#....#
Output
5 0 1 0 0 0 1 0 0 0 0 0 0 0 0
 */