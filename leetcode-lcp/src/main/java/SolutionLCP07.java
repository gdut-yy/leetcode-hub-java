import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionLCP07 {
    private int n;
    private int k;
    private Map<Integer, List<Integer>> adj;
    private int res = 0;

    // dfs 模拟，时间复杂度 O(n^k)
    public int numWays(int n, int[][] relation, int k) {
        this.n = n;
        this.k = k;
        adj = new HashMap<>();
        for (int[] rela : relation) {
            adj.computeIfAbsent(rela[0], key -> new ArrayList<>()).add(rela[1]);
        }
        dfs(0, 0);
        return res;
    }

    private void dfs(int x, int step) {
        if (step == k) {
            if (x == n - 1) {
                res++;
            }
            return;
        }
        for (int next : adj.getOrDefault(x, new ArrayList<>())) {
            dfs(next, step + 1);
        }
    }

    // 动态规划
    // 时间复杂度 O(mk) 其中 m = relation.length
    public int numWays2(int n, int[][] relation, int k) {
        // f[i][j] 表示第 i 轮传递到玩家 j 的方案数
        // 压缩掉 i
        int[] f = new int[n];
        // 初始状态
        f[0] = 1;
        // 状态转移
        for (int i = 0; i < k; i++) {
            int[] f1 = new int[n];
            for (int[] tuple : relation) {
                f1[tuple[1]] += f[tuple[0]];
            }
            f = f1;
        }
        return f[n - 1];
    }
}
/*
LCP 07. 传递信息
https://leetcode.cn/problems/chuan-di-xin-xi/

小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
1.有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
2.每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
3.每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
限制：
2 <= n <= 10
1 <= k <= 5
1 <= relation.length <= 90, 且 relation[i].length == 2
0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]

dfs 模拟/动态规划
 */