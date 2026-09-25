import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ponyai003 {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        // t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        new Solver().run();
    }

    static class Edge {
        int to, dir, dist;

        Edge(int to, int dir, int dist) {
            this.to = to;
            this.dir = dir;
            this.dist = dist;
        }
    }

    static class State {
        long d;
        int node, dir;

        State(long d, int node, int dir) {
            this.d = d;
            this.node = node;
            this.dir = dir;
        }
    }

    static class Solver {
        int N;
        ArrayList<int[]> roads = new ArrayList<>();
        int H;
        ArrayList<int[]> nodes = new ArrayList<>();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        int[] lastNode;
        int sourceId = -1, targetId = -1;
        int SX, SY, TX, TY;
        long T1, T2, T3;
        int current_node = -1;
        int cx = -1, cy = -1;

        void run() {
            N = scanner.nextInt();
            for (int i = 0; i < N; i++) {
                int x1 = scanner.nextInt();
                int y1 = scanner.nextInt();
                int x2 = scanner.nextInt();
                int y2 = scanner.nextInt();
                if (x1 == x2) {
                    if (y1 > y2) {
                        int tmp = y1;
                        y1 = y2;
                        y2 = tmp;
                    }
                    roads.add(new int[]{0, x1, y1, y2});
                } else {
                    if (x1 > x2) {
                        int tmp = x1;
                        x1 = x2;
                        x2 = tmp;
                    }
                    roads.add(new int[]{1, y1, x1, x2});
                }
            }

            SX = scanner.nextInt();
            SY = scanner.nextInt();
            TX = scanner.nextInt();
            TY = scanner.nextInt();
            T1 = scanner.nextLong();
            T2 = scanner.nextLong();
            T3 = scanner.nextLong();

            if (SX == TX && SY == TY) {
                out.println(0);
                return;
            }

            Collections.sort(roads, (a, b) -> {
                for (int i = 0; i < 4; i++) {
                    if (a[i] != b[i]) return Integer.compare(a[i], b[i]);
                }
                return 0;
            });

            H = 0;
            for (; H < roads.size(); H++) {
                if (roads.get(H)[0] == 1) break;
            }

            lastNode = new int[N - H];
            Arrays.fill(lastNode, -1);

            for (int i = 0; i < H; i++) {
                int[] road = roads.get(i);
                int vx = road[1], vy1 = road[2], vy2 = road[3];

                if (current_node < 0 || cx != vx || cy != vy1) {
                    current_node = addNode(vx, vy1);
                    cx = vx;
                    cy = vy1;
                }

                for (int j = H; j < roads.size(); j++) {
                    int[] hroad = roads.get(j);
                    int hy = hroad[1], hx1 = hroad[2], hx2 = hroad[3];

                    if (hx1 <= vx && vx <= hx2 && vy1 <= hy && hy <= vy2) {
                        int from;
                        if (lastNode[j - H] < 0) {
                            if (cx == hx1 && cy == hy) {
                                lastNode[j - H] = current_node;
                                from = current_node;
                            } else {
                                from = addNode(hx1, hy);
                            }
                        } else {
                            from = lastNode[j - H];
                        }

                        if (from != current_node) {
                            lastNode[j - H] = current_node = addCross(current_node, from, vx, hy);
                            cy = hy;
                        }
                    }
                }

                if (cy != vy2) {
                    int to = addNode(vx, vy2);
                    current_node = addSegment(current_node, to, cx, cy, vx, vy2);
                    cy = vy2;
                }
            }

            for (int j = H; j < roads.size(); j++) {
                int[] hroad = roads.get(j);
                int hy = hroad[1], hx1 = hroad[2], hx2 = hroad[3];

                int from = lastNode[j - H];
                if (from < 0) {
                    from = addNode(hx1, hy);
                }

                int[] node = nodes.get(from);
                int cx0 = node[0], cy0 = node[1];

                if (cx0 != hx2) {
                    int to = addNode(hx2, hy);
                    addSegment(from, to, cx0, cy0, hx2, hy);
                }
            }

            int nNodes = nodes.size();
            long[] dist = new long[nNodes * 4];
            Arrays.fill(dist, Long.MAX_VALUE);

            PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
                if (a.d != b.d) return Long.compare(a.d, b.d);
                if (a.node != b.node) return Integer.compare(a.node, b.node);
                return Integer.compare(a.dir, b.dir);
            });

            for (int dir = 0; dir < 4; dir++) {
                pq.add(new State(0, sourceId, dir));
                dist[sourceId * 4 + dir] = 0;
            }

            while (!pq.isEmpty()) {
                State st = pq.poll();
                long d = st.d;
                int nodeId = st.node;
                int dir = st.dir;

                if (nodeId == targetId) {
                    out.println(d);
                    return;
                }

                for (Edge e : graph.get(nodeId)) {
                    int id2 = e.to, dir2 = e.dir, dist2 = e.dist;

                    long nt;
                    if (nodeId == sourceId) {
                        nt = d + dist2;
                    } else {
                        nt = nextTime(d, dir, dir2, dist2);
                    }

                    if (nt < dist[id2 * 4 + dir2]) {
                        dist[id2 * 4 + dir2] = nt;
                        pq.add(new State(nt, id2, dir2));
                    }
                }
            }

            out.println(-1);
        }

        int addNode(int nx, int ny) {
            if (nx == SX && ny == SY) {
                sourceId = nodes.size();
            }
            if (nx == TX && ny == TY) {
                targetId = nodes.size();
            }
            nodes.add(new int[]{nx, ny});
            graph.add(new ArrayList<>());
            return nodes.size() - 1;
        }

        void addSegmentInternal(int from, int to, int dist, int dir) {
            graph.get(from).add(new Edge(to, dir, dist));
            graph.get(to).add(new Edge(from, (dir + 2) % 4, dist));
        }

        int addSegment(int from, int to, int cx, int cy, int nx, int ny) {
            int dir;

            if (cx == nx) {
                dir = 1;

                if (cx == SX && cy < SY && SY < ny) {
                    if (cx == TX && cy < TY && TY < ny) {
                        targetId = addNode(TX, TY);
                        sourceId = addNode(SX, SY);

                        if (TY < SY) {
                            addSegmentInternal(from, targetId, TY - cy, dir);
                            addSegmentInternal(targetId, sourceId, SY - TY, dir);
                            addSegmentInternal(sourceId, to, ny - SY, dir);
                        } else {
                            addSegmentInternal(from, sourceId, SY - cy, dir);
                            addSegmentInternal(sourceId, targetId, TY - SY, dir);
                            addSegmentInternal(targetId, to, ny - TY, dir);
                        }
                    } else {
                        sourceId = addNode(SX, SY);
                        addSegmentInternal(from, sourceId, SY - cy, dir);
                        addSegmentInternal(sourceId, to, ny - SY, dir);
                    }
                } else if (cx == TX && cy < TY && TY < ny) {
                    targetId = addNode(TX, TY);
                    addSegmentInternal(from, targetId, TY - cy, dir);
                    addSegmentInternal(targetId, to, ny - TY, dir);
                } else {
                    addSegmentInternal(from, to, ny - cy, dir);
                }
            } else {
                dir = 0;

                if (cy == SY && cx < SX && SX < nx) {
                    if (cy == TY && cx < TX && TX < ny) {
                        targetId = addNode(TX, TY);
                        sourceId = addNode(SX, SY);

                        if (TX < SX) {
                            addSegmentInternal(from, targetId, TX - cx, dir);
                            addSegmentInternal(targetId, sourceId, SX - TX, dir);
                            addSegmentInternal(sourceId, to, nx - SX, dir);
                        } else {
                            addSegmentInternal(from, sourceId, SX - cx, dir);
                            addSegmentInternal(sourceId, targetId, TX - SX, dir);
                            addSegmentInternal(targetId, to, nx - TX, dir);
                        }
                    } else {
                        sourceId = addNode(SX, SY);
                        addSegmentInternal(from, sourceId, SX - cx, dir);
                        addSegmentInternal(sourceId, to, nx - SX, dir);
                    }
                } else if (cy == TY && cx < TX && TX < nx) {
                    targetId = addNode(TX, TY);
                    addSegmentInternal(from, targetId, TX - cx, dir);
                    addSegmentInternal(targetId, to, nx - TX, dir);
                } else {
                    addSegmentInternal(from, to, nx - cx, dir);
                }
            }

            return to;
        }

        int addCross(int from1, int from2, int nx, int ny) {
            int[] n1 = nodes.get(from1);
            int[] n2 = nodes.get(from2);

            int cx1 = n1[0], cy1 = n1[1];
            int cx2 = n2[0], cy2 = n2[1];

            if (cx1 == nx && cy1 == ny) {
                addSegment(from2, from1, cx2, cy2, nx, ny);
                return from1;
            } else if (cx2 == nx && cy2 == ny) {
                addSegment(from1, from2, cx1, cy1, nx, ny);
                return from2;
            } else {
                int to = addNode(nx, ny);
                addSegment(from1, to, cx1, cy1, nx, ny);
                addSegment(from2, to, cx2, cy2, nx, ny);
                return to;
            }
        }

        long nextTime(long currentTime, int dir1, int dir2, int dist) {
            int chdir = (dir2 + 4 - dir1) % 4;

            if (chdir == 2) {
                return Long.MAX_VALUE;
            } else if (chdir == 3) {
                return currentTime + dist;
            } else if (chdir == 0) {
                long r = currentTime % (T1 + T2 + T3);
                if (r >= T1) {
                    return currentTime + dist;
                } else {
                    return currentTime + T1 - r + dist;
                }
            } else {
                long r = currentTime % (T1 + T2 + T3);
                if (r >= T1 && r < T1 + T2) {
                    return currentTime + dist;
                } else if (r < T1) {
                    return currentTime + T1 - r + dist;
                } else {
                    return currentTime + T1 + T2 + T3 - r + T1 + dist;
                }
            }
        }
    }
}
/*
Pony.ai-003. 路径规划
https://leetcode.cn/problems/YZJQkT/

路径规划对于自动驾驶来说是非常重要的一环，它决定了自动驾驶的车辆如何在道路上行驶。现在给出一个城市的地图，请规划出最快从起点到达终点的路线。
地图中的路都平行于 X 轴或 Y 轴，所有的路是双向通行的。路与路的交叉点有交通灯限制通行，所有的交通灯都是统一周期控制的。
交通灯共有三种不同的状态。第一种是只能右转，维持 T1 秒；第二种是可以直行左转和右转，维持 T2 秒；第三种是只能直行和右转，维持 T3 秒。
三种状态按顺序交替循环，即:
[0, T1), [T1 + T2 + T3, 2T1 + T2 + T3), [2T1 + 2T2 + 2T3, 3T1 + 2T2 + 2T3) 时只能右转
[T1, T1 + T2), [2T1 + T2 + T3, 2T1 + 2T2 + T3), [3T1 + 2T2 + 2T3, 3T1 + 3T2 + 2T3) 时可以直行左转和右转
[T1 + T2, T1 + T2 + T3), [2T1 + 2T2 + T3, 2T1 + 2T2 + 2T3), [3T1 + 3T2 + 2T3, 3T1 + 3T2 + 3T3) 时可以直行和右转，如此类推。
路的中间和路口都无法掉头。假设车的速度为 1 单位长度/s，在起点处车可以自己选择启动的方向，给出起点和终点的坐标，问从起点开到终点最少需要的时间。
输入描述：
第一行输入道路的条数 N。
然后 N 行，每行 4 个整数 X1 Y1 X2 Y2，表示每条道路两个端点的坐标。输入保证每条道路平行于 X 轴或 Y 轴，每条路的长度都大于 0,，道路之间不会有长度大于 0 的重合。
然后一行 4 个整数 SX SY TX TY，表示起点和终点的坐标。保证起点和终点位于道路上。
最后一行 3 个整数 T0 T1 T2，表示交通灯三种状态的持续时间。
输出描述：
输出到达终点的最少时间。数据保证可以从起点走到终点。
备注：
60% 的数据，N ≤ 100，所有坐标，X,Y ∈[0,100]，0 < T1,T2,T3 ≤100
100% 的数据，N ≤1000，所有坐标， X,Y ∈[0,1000000000]，0 < T1,T2,T3 ≤1000000000
示例 1
输入
2
0 2 4 2
2 0 2 4
1 2 2 1
1 1 1
输出
2
说明
只要直接往东走 1，右转之后往南走 1 就可以到达终点。
示例 2
输入
4
0 0 0 2
0 1 1 1
1 0 1 2
1 2 2 2
0 0 2 2
1 1 1
输出
6
说明
先往北走 1，再右转往东走 1，需要等 2 秒才能左转，之后再往北走 1 和右转往东走 1 就可以到达终点，总共需要时间 6 秒。
 */