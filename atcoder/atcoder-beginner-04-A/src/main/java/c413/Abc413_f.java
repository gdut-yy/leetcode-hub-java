package c413;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Abc413_f {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static void solve() {
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] dist = new int[h][w];
        for (int i = 0; i < h; i++) Arrays.fill(dist[i], -1);
        int[][] cnt = new int[h][w];
        Queue<int[]> que = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            dist[x][y] = 0;
            cnt[x][y] = 4;
            que.add(new int[]{x, y});
        }
        long ans = 0;
        while (!que.isEmpty()) {
            int[] p = que.remove();
            int x = p[0], y = p[1];
            ans += dist[x][y];
            for (int[] d : DIRECTIONS) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                cnt[nx][ny]++;
                if (dist[nx][ny] == -1 && cnt[nx][ny] == 2) {
                    dist[nx][ny] = dist[x][y] + 1;
                    que.add(new int[]{nx, ny});
                }
            }
        }
        out.println(ans);
    }
}
/*
F - No Passage
https://atcoder.jp/contests/abc413/tasks/abc413_f

题目大意：
有一个 H * W 网格。让 (i,j) 表示从上往下第 i 行，从左往上第 j 列的单元格。其中， K 个单元格是目标。第 i 个目标 (1 <= i <= K) 是单元格 (R_i, C_i) 。
高桥（Takahashi）和青木（Aoki）利用这个网格和放置在网格上的一个棋子下了一盘棋。高桥和青木反复执行以下一系列操作，直到棋子到达目标单元格：
- 青木在 1 和 4 之间选择一个整数 a 。
- 然后，高桥在 1 和 4 （含）之间选择一个整数 b ，其中必须满足 a != b 。假设 (i,j) 是操作前放置棋子的单元格。根据所选整数 b 和棋子的位置，移动棋子。
    - 当 b=1 ：如果 (i-1,j) 位于网格内，则将棋子从 (i,j) 单元格移动到 (i-1,j) 单元格；如果位于网格外，则不做任何操作。
    - 当 b=2 ：如果 (i+1,j) 位于网格内，将棋子从 (i,j) 单元格移动到 (i+1,j) 单元格；如果位于网格外，则不做任何操作。
    - 当 b=3 ：如果 (i,j-1) 位于网格内，将棋子从 (i,j) 单元格移动到 (i,j-1) 单元格；如果位于网格外，则不做任何操作。
    - 当 b=4 ：如果 (i,j+1) 位于网格内，则将棋子从 (i,j) 单元格移动到 (i,j+1) 单元格；如果位于网格外，则不做任何操作。
高桥的目标是在棋子到达目标之前尽量减少走棋次数。青木的目标是阻止棋子到达目标；如果这不可能，他的目标则是最大化棋子到达目标前的步数。
对于满足 1 <= i <= H,1 <= j <= W 的所有整数对 (i,j) ，求解下面的问题并找出所有解的和：
> 开始下棋时，棋子位于 (i,j) 小格。假设两位棋手都朝着各自的目标采取最优行动。如果高桥能使棋子达到目标，那么解就是最少的步数；否则，解就是 0 。

https://atcoder.jp/contests/abc413/editorial/13408
======

Input 1
2 3 2
1 2
2 1
Output 1
2

Input 2
9 3 9
1 3
6 1
4 1
1 2
2 1
7 1
9 3
8 1
9 2
Output 2
43

Input 3
10 10 36
3 8
5 10
3 10
6 10
2 10
2 8
7 10
1 10
1 8
7 6
7 8
2 5
1 6
8 8
7 5
2 4
9 8
7 4
4 3
10 10
10 8
8 10
10 6
6 2
4 2
10 5
8 3
1 2
2 1
4 1
10 4
10 3
8 1
6 1
10 2
9 1
Output 3
153
 */
