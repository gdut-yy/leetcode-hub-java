package p506;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF506D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] abc = new int[m][3];
        for (int i = 0; i < m; i++) {
            abc[i][0] = scanner.nextInt();
            abc[i][1] = scanner.nextInt();
            abc[i][2] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        int[][] uv = new int[q][2];
        for (int i = 0; i < q; i++) {
            uv[i][0] = scanner.nextInt();
            uv[i][1] = scanner.nextInt();
        }
        System.out.println(solve(n, m, abc, q, uv));
    }

    static int N = 100005, B = 325;
    static int[] vis, X, Y, q, d;
    static boolean[] v;
    static int n, m, q0, L, b1, d1;
    static Map<Integer, List<int[]>> edges;
    static Map<Integer, List<Integer>> e;
    static BitSet[] b;

    // https://codeforces.com/contest/506/submission/207026235
    private static String solve(int n, int m, int[][] abc, int q0, int[][] uv) {
        d = new int[N];
        v = new boolean[N];
        b = new BitSet[N];
        X = new int[N];
        Y = new int[N];
        Arrays.setAll(b, o -> new BitSet(B));
        b1 = 0;
        // init end

        edges = new HashMap<>();
        for (int[] tuple : abc) {
            int x = tuple[0], y = tuple[1], c = tuple[2];
            edges.computeIfAbsent(c, key -> new ArrayList<>()).add(new int[]{x, y});
        }

        ++n;
        int L = (int) Math.sqrt(Math.max(m, q0));
        Map<Long, Integer> hash = new HashMap<>();
        for (int i = 0; i < q0; i++) {
            int x = Math.min(uv[i][0], uv[i][1]);
            int y = Math.max(uv[i][0], uv[i][1]);
            X[i] = x;
            Y[i] = y;
            long key = (long) x * n + y;
            hash.put(key, 0);
        }

        int[] q = new int[N];
        e = new HashMap<>();
        for (int c = 1; c < m + 1; c++) {
            int q1 = 0;
            for (int[] tuple : edges.getOrDefault(c, new ArrayList<>())) {
                int x = tuple[0], y = tuple[1];
                q[q1++] = x;
                q[q1++] = y;
                e.computeIfAbsent(x, key -> new ArrayList<>()).add(y);
                e.computeIfAbsent(y, key -> new ArrayList<>()).add(x);
            }
            for (int i = 0; i < q1; i++) {
                int x = q[i];
                if (!v[x]) {
                    d1 = 0;
                    dfs(x);
                    if (d1 < L) {
                        // sort(d, d + d1);
                        Arrays.sort(d, 0, d1);
                        for (int j = 0; j < d1; j++) {
                            for (int k = j + 1; k < d1; k++) {
                                int x1 = d[j], y1 = d[k];
                                long key = (long) x1 * n + y1;
                                if (hash.containsKey(key)) {
                                    hash.put(key, hash.getOrDefault(key, 0) + 1);
                                }
                            }
                        }
                    } else {
                        for (int j = 0; j < d1; j++) {
                            b[d[j]].set(b1, true);
                        }
                        ++b1;
                    }
                }
            }
            for (int i = 0; i < q1; i++) {
                v[q[i]] = false;
                e.getOrDefault(q[i], new ArrayList<>()).clear();
            }
        }

        int[] ans = new int[q0];
        for (int i = 0; i < q0; i++) {
            BitSet bxi = (BitSet) b[X[i]].clone();
            bxi.and(b[Y[i]]);
            ans[i] = hash.get((long) X[i] * n + Y[i]) + bxi.cardinality();
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    private static void dfs(int x) {
        v[x] = true;
        d[d1++] = x;
        for (int y : e.getOrDefault(x, new ArrayList<>())) {
            if (!v[y]) {
                dfs(y);
            }
        }
    }
}
/*
D. Mr. Kitayuta's Colorful Graph
https://codeforces.com/contest/506/problem/D

灵茶の试炼 2023-05-22
题目大意：
Kitayuta 先生刚刚买了一个有 n 个顶点和 m 条边的无向图（2≤n≤1e5, 1≤m≤1e5）。图的顶点编号从 1 到 n。每条边，即边 i，有一个颜色 ci，连接顶点 ai 和 bi。
北太先生希望您处理以下 q 个查询。
在第 i 个查询中，他给出了两个整数 ui 和 vi。
找出满足以下条件的颜色的个数:该颜色的边直接或间接连接顶点 ui 和顶点 vi。

rating 2400
hqztrue：
法1. 分块+压位。考虑所有大小<L的连通块对答案的贡献，可以通过枚举所有小连通块中的点对得到，总复杂度为 O(nL)。
然后考虑包含 >= L 个点的大连通块，一共有 n/L 个。对每个点 v，用长为 n/L 的 01 向量记下包含它的大连通块，
这些向量可以用 O(n) 的时间从全零更新得到。对于每个询问，可以在 O(n/L/w) 的复杂度内计算大连通块对它的贡献。
平衡一下，取 L=sqrt(n/w)。复杂度为 O(n*sqrt(n/w)).
---
法2. 分块+矩阵乘法。分三种情况统计：
1）小连通块的贡献，做法如上，复杂度 O(nL)。
2）令 d(v) 表示包含 v 的大连通块的数量，设一个阈值 B，只有 O(n/B) 个点满足 d(v) >= B，成它们为度数大的点。
可以用矩阵乘法在 M(n/B, n/L, n/B) 的时间内，算出每对度数大的点之间的答案。
3）如果一条询问中包含至少一个度数小的点 v，则可以枚举所有包含 v 的大连通块的颜色，在 O(B) 的时间内统计。
取 B=L=n^{(w-1)/(w+1)}, 总复杂度 O(n^{2w/(w+1)}) ≈ O(n^1.407)
相似题目: B. Mr. Kitayuta's Colorful Graph
https://codeforces.com/contest/505/problem/B
======

input
4 5
1 2 1
1 2 2
2 3 1
2 3 3
2 4 3
3
1 2
3 4
1 4
output
2
1
0

input
5 7
1 5 1
2 5 1
3 5 1
4 5 1
1 2 2
2 3 2
3 4 2
5
1 5
5 1
2 5
1 5
1 4
output
1
1
1
1
2
 */
