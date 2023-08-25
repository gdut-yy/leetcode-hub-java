package c301;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Abc301_e {
    static int n, m, t;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        t = scanner.nextInt();
        a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static final int INF = (int) 1e9;
    static int sx, sy, tx, ty;
    static List<int[]> ps;

    private static String solve() {
        ps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (a[i][j] == 'G') {
                    tx = i;
                    ty = j;
                } else if (a[i][j] == 'o') {
                    ps.add(new int[]{i, j});
                }
            }
        }
        ps.add(new int[]{sx, sy});
        ps.add(new int[]{tx, ty});
        int k = ps.size();
        Map<Long, Integer> idx = new HashMap<>();
        for (int i = 0; i < ps.size(); i++) {
            long key = (long) ps.get(i)[0] << 32 | ps.get(i)[1];
            idx.put(key, i);
        }

        int[][] vis = new int[n][m];
        int[][] dis = new int[k][k];
        for (int i = 0; i < k; i++) {
            Arrays.fill(dis[i], INF);
        }
        for (int i = 0; i < ps.size(); i++) {
            int[] p = ps.get(i);
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{p[0], p[1]});
            vis[p[0]][p[1]] = i + 1;
            int step = 1;
            while (!queue.isEmpty()) {
                int sz = queue.size();
                while (sz-- > 0) {
                    int[] tuple = queue.remove();
                    int cx = tuple[0], cy = tuple[1];

                    for (int[] dir : DIRECTIONS) {
                        int nx = cx + dir[0];
                        int ny = cy + dir[1];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m
                                && vis[nx][ny] != i + 1 && a[nx][ny] != '#') {
                            if (a[nx][ny] != '.') {
                                Integer j1 = idx.get((long) nx << 32 | ny);
                                dis[i][j1] = step;
                            }
                            vis[nx][ny] = i + 1;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
                step++;
            }
        }
        if (dis[k - 2][k - 1] > t) {
            return "-1";
        }

        // 下面 k 表示起点，k+1 表示终点
        k -= 2;
        int[][] f = new int[1 << k][k];
        for (int i = 0; i < 1 << k; i++) {
            Arrays.fill(f[i], INF);
        }
        for (int i = 0; i < k; i++) {
            int d = dis[k][i];
            f[1 << i][i] = d;
        }
        int ans = 0;
        for (int s = 0; s < 1 << k; s++) {
            int[] dr = f[s];
            // for _s := uint(s); _s > 0; _s &= _s - 1 {
            for (int _s = s; _s > 0; _s &= (_s - 1)) {
                int i = Integer.numberOfTrailingZeros(_s);
                if (dr[i] + dis[k + 1][i] <= t) {
                    ans = Math.max(ans, Integer.bitCount(s));
                }
                // for cus, lb := len(f)-1^s, 0; cus > 0; cus ^= lb {
                for (int cus = f.length - 1 ^ s, lb = 0; cus > 0; cus ^= lb) {
                    lb = cus & -cus;
                    int ns = s | lb;
                    int j = Integer.numberOfTrailingZeros(lb);
                    f[ns][j] = Math.min(f[ns][j], dr[i] + dis[i][j]);
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
E - Pac-Takahashi
https://atcoder.jp/contests/abc301/tasks/abc301_e

灵茶の试炼 2023-08-17
题目大意：
我们有一个 H 行 W 列的网格。设(i,j)表示从上到下第 i 行和从左到第 j 列的正方形。网格中的每个方格是下列方格之一:
起始方格、目标方格、空方格、墙方格和糖果方格。(i,j)由字符 a i,j 表示，
如果 a i,j = S，则为起始正方形，
如果 a i,j = G，则为目标正方形，
如果 a i,j = .，则为空正方形，
如果 a i,j = #，则为墙正方形，
如果 a i,j = o，则为糖果正方形，
保证只有一个起点，只有一个目标，最多 18 个糖果正方形。
高桥现在在起跑线上。他可以重复移动到垂直或水平相邻的无墙方块。他想在最多 T 步内到达目标方格。
确定它是否可能。如果可能的话，找出他在到达目标方块的路上可以访问的糖果方块的最大数量，他必须在那里完成任务。每个糖果方块只计数一次，即使它被访问多次。

https://atcoder.jp/contests/abc301/submissions/44602551
计算每对 o 之间的最短距离，用 dis 数组记录。这一步可以用 BFS 解决。
由于 o 至多有 18 个，可以转换成一个旅行商问题（请自行搜索），用状压 DP 解决。
定义 f[s][i] 表示已收集的 o 的下标集合为 s，且当前在第 i 个 o 时的最小移动步数。
枚举 s 的补集中的下标 j，用 f[s][i] + dis[i][j] 去更新 f[s|1<<j][j] 的最小值。
为了简化代码，可以把起点和终点也视作 o。
不过这样会慢一些，代码把起点终点单独处理了。
时间复杂度 O(knm+k^2*2^k)。
相似题目: LCP 13. 寻宝
https://leetcode.cn/problems/xun-bao/
======

Input 1
3 3 5
S.G
o#o
.#.
Output 1
1

Input 2
3 3 1
S.G
.#o
o#.
Output 2
-1

Input 3
5 10 2000000
S.o..ooo..
..o..o.o..
..o..ooo..
..o..o.o..
..o..ooo.G
Output 3
18
 */