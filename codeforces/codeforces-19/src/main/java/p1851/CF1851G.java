package p1851;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1851G {
    static int n, m;
    static int[][] h;
    static int[][] uv;
    static int q;
    static int[][] req;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            h = new int[n][2];
            for (int i = 0; i < n; i++) {
                h[i][0] = scanner.nextInt();
                h[i][1] = i;
            }
            uv = new int[m][2];
            for (int i = 0; i < m; i++) {
                uv[i][0] = scanner.nextInt() - 1;
                uv[i][1] = scanner.nextInt() - 1;
            }
            q = scanner.nextInt();
            req = new int[q][4];
            for (int i = 0; i < q; i++) {
                int a = scanner.nextInt() - 1;
                int b = scanner.nextInt() - 1;
                int e = scanner.nextInt();
                req[i][2] = a;
                req[i][3] = b;
                // e.x.x += h[e.y.x].x;
                req[i][0] = e + h[a][0];
                req[i][1] = i;
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Map<Integer, List<Integer>> sl = new HashMap<>();
        for (int[] p : uv) {
            int u = p[0], v = p[1];
            if (h[u][0] > h[v][0]) sl.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            else sl.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
        }

        Arrays.sort(h, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(req, Comparator.comparingInt(o -> o[0]));
        DSU dsu = new DSU(n);
        String[] ans = new String[q];
        int j = 0;
        for (int[] e : req) {
            while (j < n && h[j][0] <= e[0]) {
                for (Integer u : sl.getOrDefault(h[j][1], new ArrayList<>())) {
                    dsu.union(h[j][1], u);
                }
                j++;
            }
            ans[e[1]] = dsu.find(e[2]) == dsu.find(e[3]) ? "YES" : "NO";
        }

        return String.join(System.lineSeparator(), ans);
    }

    private static class DSU {
        int[] fa;
        int[] lvl;

        public DSU(int n) {
            fa = new int[n];
            lvl = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
                lvl[i] = i;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;
            if (lvl[a] < lvl[b]) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            fa[b] = a;
            if (lvl[a] == lvl[b]) {
                lvl[a]++;
            }
        }
    }
}
/*
G. Vlad and the Mountains
https://codeforces.com/contest/1851/problem/G

灵茶の试炼 2024-06-27
题目大意：
Vlad 决定去山里旅行。他计划在 n 座山之间移动，其中一些山之间有公路连接。这座山的高度是 hi 英尺。
如果山 i 和山 j 之间有一条路，Vlad 可以通过消耗 hj - hi 单位能量从山 i 移动到山 j。如果他的能量在转换过程中降到零以下，他将无法从山 i 移动到山 j。注意，hj - hi 可以是负的，然后能量会被恢复。
Vlad 想要考虑不同的路线选择，所以他让你回答以下问题:是否有可能构造一些从 a 山开始到 b 山结束的路线，假设他最初有 e 个单位的能量?

rating 2000
https://codeforces.com/blog/entry/118667
我们考虑从 i→j→k 移动时能量的变化，hi-hj+hj-hk=hi-hk，可以看出这是路径上第一座山和最后一座山的高度之差。换句话说，从顶点 a 出发，有可能到达任何顶点，只要路径不经过高度大于 ha+e 的顶点。
因此，对于每个查询，有必要从顶点 a 构建一个组件，其中包括所有高度不大于 ha+e 的顶点，并检查顶点 b 是否在其中。为了有效地做到这一点，让我们按 ha+e 对查询进行排序，并按 max(hu,hv)对图的边进行排序，并维护一个不相交集数据结构(DSU)。
在每个查询之前，添加所有尚未添加的边，并且它们的 max(hu,hv)对于该特定查询不大于 ha+e。在此之后，只检查顶点 a 和 b 是否属于相同的连接组件。
======

input
2
7 7
1 5 3 4 2 4 1
1 4
4 3
3 6
3 2
2 5
5 6
5 7
5
1 1 3
6 2 0
4 7 0
1 7 4
1 7 2
6 5
4 7 6 2 5 1
1 3
5 3
1 5
2 4
6 2
5
1 5 1
1 3 1
1 2 1000
6 2 6
6 2 5
output
YES
NO
YES
YES
NO

YES
NO
NO
YES
NO

input
2
3 2
1 3 9
1 2
2 3
5
1 1 1
3 2 2
1 1 2
3 3 0
1 2 1
3 3
1 4 1
1 2
2 3
1 3
5
3 3 9
1 3 6
1 1 2
3 3 6
3 3 4
output
YES
YES
YES
YES
NO

YES
YES
YES
YES
YES

input
1
6 10
7 9 2 10 8 6
4 2
6 1
4 5
3 5
6 4
1 3
2 6
6 5
1 2
3 6
5
4 4 8
3 3 1
5 5 9
2 1 7
6 6 10
output
YES
YES
YES
YES
YES
 */
