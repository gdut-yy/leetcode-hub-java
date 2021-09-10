import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Meituan005 {
    private static int k;
    private static int[] level;
    private static boolean[] used;
    private static final int MOD = 1000000007;
    private static List<List<Integer>> listList;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        k = in.nextInt();
        listList = new ArrayList<>();
        level = new int[n + 1];
        used = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            listList.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            listList.get(x).add(y);
            listList.get(y).add(x);
        }
        for (int i = 1; i <= n; i++) {
            level[i] = in.nextInt();
        }
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(used, false);
            ans = (ans + dfs(i, i)) % MOD;
        }
        System.out.println(ans);
    }

    private static long dfs(int u, int s) {
        used[u] = true;
        long ans = 1;
        for (int v : listList.get(u)) {
            if (used[v]) {
                continue;
            }
            if (level[v] > level[s] && level[v] - level[s] <= k || level[v] == level[s] && v > s) {
                ans = ans * (1 + dfs(v, s)) % MOD;
            }
        }
        return ans;
    }
}
/*
小美是美团总部的高管，她想要召集一些美团的区域负责人来开会，已知美团的业务区域划分可以用一棵树来表示，树上有 n 个节点，每个节点分别代表美团的一个业务区域，每一个区域有一个负责人，这个负责人的级别为 A[i]
已知小美召集人员开会必须满足以下几个条件：
1.小美召集的负责人所在的区域必须构成一个非空的连通的图，即选取树上的一个连通子图。
2.这些负责人中，级别最高的和级别最低的相差不超过 k 。
请问小美有多少种召集负责人的方式，当且仅当选取的集合不同时我们就认为两种方式不同。由于方案数可能非常大，所以请对 10^9+7 取模。

格式：


输入：
- 输入第一行包含两个整数 n 和 k ，表示区域的数量，和不能超过的级别。
- 接下来有 n-1 行，每行有两个正整数 a 和 b ，表示 a 号区域和 b 号区域有一条边。
- 最后一行有 n 个整数，第 i 个整数表示 i 号区域负责人的级别。
输出：
- 输出仅包含一个整数，表示可以选择的方案数对 10^9+7 取模之后的结果。
示例：


输入：
5 1
1 2
2 3
3 4
4 5
2 2 2 2 2
输出：15
解释：显然一个区域的方案有 {1}，{2}，{3}，{4}，{5}，两个区域的方案有 4 个，三个区域的方案有 3 个，四个区域的方案有 2 个，五个区域的方案有 1 个，共 15 个。
提示：

1 <= n, k <= 2000
1 <= a, b <= n
 */