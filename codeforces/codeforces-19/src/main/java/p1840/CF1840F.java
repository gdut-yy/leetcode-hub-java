package p1840;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class CF1840F {
    static int n, m, r;
    static Map<Integer, Set<Integer>> rows, cols;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int T = scanner.nextInt();
        while (T-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            r = scanner.nextInt();

            rows = new HashMap<>();
            cols = new HashMap<>();
            for (int i = 0; i < r; i++) {
                int t = scanner.nextInt();
                int d = scanner.nextInt();
                int coord = scanner.nextInt();
                if (d == 1) {
                    // 水平
                    rows.computeIfAbsent(t, key -> new HashSet<>()).add(coord);
                } else {
                    // 垂直
                    cols.computeIfAbsent(t, key -> new HashSet<>()).add(coord);
                }
            }
            System.out.println(solve());
        }
    }

    private static Queue<int[]> queue;
    private static boolean[][][] vis;

    private static String solve() {
        // BFS
        queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});
        // x, y, 停留回合数
        vis = new boolean[n + 1][m + 1][r + 1];
        vis[0][0][0] = true;

        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.remove();
                int cx = tuple[0], cy = tuple[1], cr = tuple[2];
                if (cx == n && cy == m) {
                    return String.valueOf(time);
                }

                next(time, cx, cy, cr + 1);
                next(time, cx + 1, cy, cr);
                next(time, cx, cy + 1, cr);
            }
            time++;
        }
        return "-1";
    }

    private static void next(int time, int nx, int ny, int nr) {
        if (nx > n || ny > m || nr > r) return;
        if (vis[nx][ny][nr]) return;
        if (rows.getOrDefault(time + 1, new HashSet<>()).contains(nx)) return;
        if (cols.getOrDefault(time + 1, new HashSet<>()).contains(ny)) return;
        vis[nx][ny][nr] = true;
        queue.add(new int[]{nx, ny, nr, time});
    }

    private static class FastReader {
        private final BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                if (stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken("\n");
                } else {
                    str = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
/*
F. Railguns
https://codeforces.com/contest/1840/problem/F

题目大意：
Tema 正在玩一个非常有趣的电脑游戏。
在接下来的任务中，特玛的角色发现自己身处一个陌生的星球。与地球不同，这颗行星是平的，可以用 n×m 矩形表示。
Tema 的角色位于坐标(0,0)处。为了成功完成任务，他需要活着到达坐标(n,m)的点。
设电脑游戏的角色位于坐标(i,j)处。每一秒，从第一次开始，特玛可以:
- 要么使用垂直超跳技术，之后他的角色将在第二帧结束时到达坐标(i+1,j);
- 或者使用水平超跳技术，之后他的角色将在第二帧结束时到达坐标(i,j+1);
- 或者 Tema 可以选择不进行超级跳跃，在这种情况下，他的角色在这一秒内不会移动;居住在这个星球上的外星人非常危险和充满敌意。因此，他们会用轨道炮射击。
每个镜头完全穿透一个坐标垂直或水平。如果角色在射击时(即在第二回合结束时)处于其影响范围内，他便会死亡。
由于 Tema 查看了游戏的源代码，他知道关于每次射击的完整信息——时间、穿透坐标和射击方向。
角色到达预期点的最短时间是多少?如果他注定要死亡，无法到达坐标(n,m)处，输出 −1。
---
输入的第一行包含单个整数 T(1≤T≤10^4)—测试用例的数量。
然后遵循测试用例的描述。
每个测试用例的第一行包含两个整数 n 和 m(1≤n·m≤10^4)——行星的大小、宽度和高度。
每个测试用例的第二行包含单个整数 r(1≤r≤100)—射击次数。
然后沿着 r 条线，每条线描述一个镜头。
一次射击由三个整数 t, d, coord 来描述。式中 t 为射击的秒数(1≤t≤10^9)。d 为射击方向(d=1 表示水平射击，d=2 表示垂直射击)。coord 为穿透坐标的大小(d=1 时 0≤coord≤n, d=2 时 0≤coord≤m)。
所有测试用例的乘积 n·m 之和不超过 10^4。

BFS 模拟。
注意正确状态数应该是 O(n·m·r) 而不是 O(n·m·(n+m+r))
======

inputCopy
5
1 3
4
1 2 0
2 2 1
3 2 2
4 1 1
3 3
6
2 1 0
2 1 1
2 1 2
2 2 0
2 2 1
2 2 2
2 1
3
7 1 2
2 1 1
7 2 1
2 2
5
9 1 2
3 2 0
5 1 2
4 2 2
7 1 0
4 6
7
6 1 2
12 1 3
4 1 0
17 2 3
1 2 6
16 2 6
3 2 4
outputCopy
5
-1
3
6
10

1
1 10000
100
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
10000 2 10000
 */