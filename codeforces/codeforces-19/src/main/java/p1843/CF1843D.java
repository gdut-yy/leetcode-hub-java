package p1843;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1843D {
    static int n, q;
    static int[][] uv, xy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            uv = new int[n - 1][2];
            for (int i = 0; i < n - 1; i++) {
                uv[i][0] = scanner.nextInt();
                uv[i][1] = scanner.nextInt();
            }
            q = scanner.nextInt();
            xy = new int[q][2];
            for (int i = 0; i < q; i++) {
                xy[i][0] = scanner.nextInt();
                xy[i][1] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static Map<Integer, List<Integer>> adj;
    private static long[] cnt;

    private static String solve() {
        adj = new HashMap<>();
        int[] deg = new int[n];
        for (int[] p : uv) {
            int x = p[0] - 1, y = p[1] - 1;
            adj.computeIfAbsent(x, key -> new ArrayList<>()).add(y);
            adj.computeIfAbsent(y, key -> new ArrayList<>()).add(x);
            deg[x]++;
            deg[y]++;
        }
        cnt = new long[n];
        for (int i = 1; i < n; i++) {
            // deg[x] 为 1 的是叶子节点
            if (deg[i] == 1) {
                cnt[i] = 1;
            }
        }
        dfs(0, -1);

        long[] ans = new long[q];
        for (int i = 0; i < q; i++) {
            int x = xy[i][0] - 1, y = xy[i][1] - 1;
            ans[i] = cnt[x] * cnt[y];
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    private static long dfs(int x, int fa) {
        long sum = 0;
        for (Integer y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) continue;
            sum += dfs(y, x);
        }
        cnt[x] += sum;
        return cnt[x];
    }
}
/*
D. Apple Tree
https://codeforces.com/contest/1843/problem/D

题目大意：
蒂莫菲的花园里种着一棵苹果树;它是一个有 n 个顶点的根树，根在顶点 1(顶点编号从 1 到 n)。树是一个没有环路和多条边的连通图。
这棵树很不寻常，它的根向上生长。然而，这对于程序员树来说是很正常的。
这棵苹果树还很年轻，所以树上只会长出两个苹果。苹果会在特定的顶点生长(这些顶点可能是相同的)。苹果长大后，蒂莫菲开始摇苹果树，直到苹果掉下来。每次提莫菲摇苹果树，每个苹果都会发生如下的变化:
现在苹果在顶点 u 上。
- 如果顶点 u 有子顶点，苹果就会移动到它那里(如果有几个这样的顶点，苹果可以移动到其中的任何一个)。
- 否则，苹果就会从树上掉下来。
可以证明，在有限的时间后，两个苹果都会从树上掉下来。
蒂莫菲有 q 个假设，苹果可以在哪些顶点生长。他假设苹果可以在顶点 x 和 y 上生长，并想知道苹果从树上落下的顶点(a, b)对的数量，其中 a——从顶点 x 落下的苹果的顶点，b——从顶点 y 落下的苹果的顶点。帮他做这个。

统计每个节点有多少个叶子节点
======

input
2
5
1 2
3 4
5 3
3 2
4
3 4
5 1
4 4
1 3
3
1 2
1 3
3
1 1
2 3
3 1
output
2
2
1
4
4
1
2

input
2
5
5 1
1 2
2 3
4 3
2
5 5
5 1
5
3 2
5 3
2 1
4 2
3
4 3
2 1
4 2
output
1
2
1
4
2
 */
