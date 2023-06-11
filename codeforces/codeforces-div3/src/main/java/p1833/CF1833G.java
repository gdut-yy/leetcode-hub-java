package p1833;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1833G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] edges = new int[n - 1][2];
            for (int i = 0; i < n - 1; i++) {
                edges[i][0] = scanner.nextInt();
                edges[i][1] = scanner.nextInt();
            }
            System.out.println(solve(n, edges));
        }
    }

    private static Map<Integer, List<int[]>> adj;
    private static int[] sz;
    private static boolean flag;
    private static List<Integer> resList;

    // https://codeforces.com/contest/1833/submission/206487161
    private static String solve(int n, int[][] edges) {
        if (n % 3 != 0) {
            return "-1";
        }
        adj = new HashMap<>();
        for (int i = 1; i < n; i++) {
            int x = edges[i - 1][0], y = edges[i - 1][1];
            adj.computeIfAbsent(x, key -> new ArrayList<>()).add(new int[]{y, i});
            adj.computeIfAbsent(y, key -> new ArrayList<>()).add(new int[]{x, i});
        }
        sz = new int[n + 1];
        flag = true;
        resList = new ArrayList<>();

        dfs(1, 0);
        if (!flag || sz[1] != 3) {
            return "-1";
        }
        return resList.size() + System.lineSeparator()
                + resList.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    private static void dfs(int x, int fa) {
        sz[x] = 1;
        for (int[] tuple : adj.getOrDefault(x, new ArrayList<>())) {
            int y = tuple[0], edgeId = tuple[1];
            if (y == fa) continue;
            dfs(y, x);
            if (sz[y] == 3) {
                resList.add(edgeId);
                sz[y] -= 3;
            }
            sz[x] += sz[y];
        }
        if (sz[x] > 3) {
            flag = false;
        }
    }
}
/*
G. Ksyusha and Chinchilla
https://codeforces.com/contest/1833/problem/G

题目大意：
Ksyusha 有一只宠物栗鼠，一棵有 n 个顶点的树和一把巨大的剪刀。树是一个没有环的连通图。在一堂无聊的物理课上，克尤莎想到了如何逗她的宠物开心。
龙猫喜欢玩树枝。分支是一个有 3 个顶点的树。
切割是去除树的一些(尚未切割的)边缘。Ksyusha 有足够的空闲时间，所以她有足够的钱把树砍成树枝。换句话说，经过几次(可能为零)切割后，每个顶点必须只属于一个分支。
帮 Ksyusha 选择要剪的边，或者告诉他这是不可能的。

树形 DP。
子树大小为 3 就减去。大于 3 则无解。
======

input
4
9
1 2
4 3
7 9
5 4
4 6
3 2
8 7
1 7
6
1 2
1 3
4 3
1 5
6 1
6
1 2
3 2
3 4
4 5
6 5
5
1 3
5 3
5 2
3 4
output
2
2 8
-1
1
3
-1

input
4
2
1 2
3
1 2
3 1
6
1 2
3 1
3 4
3 5
6 1
9
2 6
6 9
9 1
9 7
1 8
7 3
8 5
4 7
output
-1
0

1
2
2
4 3
-1
 */
