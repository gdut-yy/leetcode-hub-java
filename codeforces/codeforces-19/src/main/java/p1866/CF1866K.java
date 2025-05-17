package p1866;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class CF1866K {
    record vec(long x, long y) {
        vec sub(vec b) {
            return new vec(x - b.x, y - b.y);
        }

        long dot(vec b) {
            return x * b.x + y * b.y;
        }

        int detCmp(vec b) {
            BigInteger v = BigInteger.valueOf(x).multiply(BigInteger.valueOf(b.y));
            BigInteger w = BigInteger.valueOf(y).multiply(BigInteger.valueOf(b.x));
            return v.compareTo(w);
        }
    }

    record nb(int to, int wt) {
    }

    static class Node {
        long fi = 0, se = 0, fiW = 0;
    }

    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static List<nb>[] g;
    static Node[] nodes;
    static long ans;
    static List<vec>[][] hulls;

    public static void main(String[] args) {
        int n = scanner.nextInt();
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            int wt = scanner.nextInt();
            g[v].add(new nb(w, wt));
            g[w].add(new nb(v, wt));
        }
        nodes = new Node[n];
        Arrays.setAll(nodes, e -> new Node());
        ans = 0;
        dfs(0, -1);

        hulls = new ArrayList[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.setAll(hulls[i], e -> new ArrayList<>());
        }
        reroot(0, -1, new vec(0, 0));

        solve();
        out.flush();
    }

    private static void solve() {
        int q = scanner.nextInt();
        for (int qi = 0; qi < q; qi++) {
            int v = scanner.nextInt();
            int px = scanner.nextInt();
            vec p = new vec(px, 1);

            List<vec> h0 = hulls[v - 1][0];
            int j = sortSearch(h0.size() - 1, m -> {
                return p.dot(h0.get(m)) > p.dot(h0.get(m + 1));
            });
            long mx = p.dot(h0.get(j));
            long mx2 = 0;
            if (j > 0) {
                mx2 = Math.max(mx2, p.dot(h0.get(j - 1)));
            }
            if (j < h0.size() - 1) {
                mx2 = Math.max(mx2, p.dot(h0.get(j + 1)));
            }

            List<vec> h1 = hulls[v - 1][1];
            if (!h1.isEmpty()) {
                j = sortSearch(h1.size() - 1, m -> {
                    return p.dot(h1.get(m)) > p.dot(h1.get(m + 1));
                });
                mx2 = Math.max(mx2, p.dot(h1.get(j)));
            }
            long res = Math.max(mx + mx2, ans);
            out.println(res);
        }
    }

    // func Search(n int, f func(int) bool) int { ... }
    static int sortSearch(int n, Function<Integer, Boolean> f) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    static long dfs(int v, int fa) {
        Node p = nodes[v];
        for (nb e : g[v]) {
            int w = e.to;
            if (w == fa) continue;

            long d = dfs(w, v) + e.wt;
            ans = Math.max(ans, p.fi + d);
            if (d > p.fi) {
                p.se = p.fi;
                p.fi = d;
                p.fiW = w;
            } else if (d > p.se) {
                p.se = d;
            }
        }
        return p.fi;
    }

    private static void reroot(int v, int fa, vec up) {
        List<vec> a = new ArrayList<>(g[v].size());
        for (nb e : g[v]) {
            int w = e.to;
            if (w == fa) {
                a.add(up);
            } else {
                a.add(new vec(e.wt, nodes[w].fi));
            }
        }

        Comparator<vec> comparator = (a1, a2) -> {
            int cmp = Long.compare(a1.x, a2.x);
            return cmp != 0 ? cmp : Long.compare(a1.y, a2.y);
        };
        a.sort(comparator);

        List<vec> q = new ArrayList<>();
        List<vec> bList = new ArrayList<>();
        for (vec vec : a) {
            while (q.size() > 1) {
                vec last1 = q.get(q.size() - 1);
                vec last2 = q.get(q.size() - 2);
                if (last1.sub(last2).detCmp(vec.sub(last1)) >= 0) {
                    bList.add(last1);
                    q.remove(q.size() - 1);
                } else {
                    break;
                }
            }
            q.add(vec);
        }
        hulls[v][0] = q;

        bList.sort(comparator);
        List<vec> q2 = new ArrayList<>();
        for (vec vec : bList) {
            while (q2.size() > 1) {
                vec last1 = q2.get(q2.size() - 1);
                vec last2 = q2.get(q2.size() - 2);
                if (last1.sub(last2).detCmp(vec.sub(last1)) >= 0) {
                    q2.remove(q2.size() - 1);
                } else {
                    break;
                }
            }
            q2.add(vec);
        }
        hulls[v][1] = q2;

        Node p = nodes[v];
        for (nb e : g[v]) {
            int w = e.to;
            if (w == fa) continue;
            long down = p.fiW == w ? p.se : p.fi;
            vec newUp = new vec(e.wt, Math.max(up.x + up.y, down));
            reroot(w, v, newUp);
        }
    }
}
/*
K. Keen Tree Calculation
https://codeforces.com/contest/1866/problem/K

灵茶の试炼 2025-04-18
题目大意：
输入 n(2≤n≤1e5) 和一棵无向树的 n-1 条边（节点编号从 1 开始），每条边包含 3 个数 x y z(1≤z≤1e9)，表示有一条边权为 z 的边连接 x 和 y。
然后输入 q(1≤q≤1e5) 和 q 个询问，每个询问输入 x 和 k(1≤k≤1e9)。
询问之间互相独立（每个询问都是在初始树上操作的）。
把所有与 x 相连的边的边权都乘以 k，
然后输出这棵树的直径。

rating 2500
如果直径不经过 x，那么答案 ans 就是初始树的直径。
首先思考 x=1 的情况。
设 x 到其儿子 y1,y2,...,ym 的边权为 a1,a2,...,am。
设各个儿子往下最远可以走的距离为 d1,d2,...,dm。
问题相当于计算最大&次大的 k * ai + di，二者拼成直径，与 ans 取最大值。
拆开成点积的形式，即 (k,1) * (ai,di)。
维护 (ai,di) 的上凸包，可以二分找最大点积。
次大点积呢？要么是二分结果的相邻位置，要么在内层凸包中。
什么是内层凸包？就是去掉外层凸包的点，剩余的点再求一遍凸包。
最后，对于其他的 x，我们可以用换根 DP 求出（来自父节点的）ai 和 di。
代码 https://codeforces.com/contest/1866/submission/315897378
代码备份（洛谷）
======

Input
7
5 1 2
1 4 2
3 4 1
2 5 3
6 1 6
4 7 2
2
4 3
3 2
Output
18
11

Input
3
1 2 1000000000
2 3 1000000000
1
2 1000000000
Output
2000000000000000000
 */
