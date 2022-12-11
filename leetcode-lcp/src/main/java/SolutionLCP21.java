import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SolutionLCP21 {
    private Map<Integer, List<Integer>> adj;

    // https://leetcode.cn/problems/Za25hA/solution/di-yi-ming-de-dai-ma-gai-xie-wei-java-by-xiaojj-r/
    public int chaseGame(int[][] edges, int startA, int startB) {
        // n 个顶点 n 条边
        int n = edges.length;

        adj = new HashMap<>();
        // 记录顶点的数量
        int[] nums = new int[n + 1];
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
            nums[edge[0]]++;
            nums[edge[1]]++;
        }

        // 标记到起点的距离
        int[] distA = new int[n + 1];
        int[] distB = new int[n + 1];
        bfs(distA, startA);
        bfs(distB, startB);

        // 找出环
        int ring = n;
        Queue<Integer> queue = new LinkedList<>();
        // 添加叶子节点
        for (int i = 1; i <= n; i++) {
            if (nums[i] == 1) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int u = queue.remove();
            ring--;
            for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                nums[v]--;
                if (nums[v] == 1) {
                    queue.add(v);
                }
            }
        }
        // 追上的步骤
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            if (distA[i] > distB[i] + 1) {
                // 表示这是环上的点，B 可以先一步到达
                if (nums[i] > 1 && ring > 3) {
                    ans = -1;
                    break;
                } else {
                    ans = Math.max(ans, distA[i]);
                }
            }

        }
        return ans;
    }

    private void bfs(int[] dist, int x) {
        Queue<Integer> queue = new LinkedList<>();
        // 起点
        queue.add(x);
        // 先初始化为 -1
        dist[x] = 0;
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                if (dist[v] == 0 && v != x) {
                    dist[v] = dist[u] + 1;
                    queue.add(v);
                }
            }
        }
    }
}
/*
LCP 21. 追逐游戏
https://leetcode.cn/problems/Za25hA/

秋游中的小力和小扣设计了一个追逐游戏。他们选了秋日市集景区中的 N 个景点，景点编号为 1~N。此外，他们还选择了 N 条小路，
满足任意两个景点之间都可以通过小路互相到达，且不存在两条连接景点相同的小路。整个游戏场景可视作一个无向连通图，记作二维数组 edges，数组中以 [a,b] 形式表示景点 a 与景点 b 之间有一条小路连通。
小力和小扣只能沿景点间的小路移动。小力的目标是在最快时间内追到小扣，小扣的目标是尽可能延后被小力追到的时间。
游戏开始前，两人分别站在两个不同的景点 startA 和 startB。每一回合，小力先行动，小扣观察到小力的行动后再行动。小力和小扣在每回合可选择以下行动之一：
- 移动至相邻景点
- 留在原地
如果小力追到小扣（即两人于某一时刻出现在同一位置），则游戏结束。若小力可以追到小扣，请返回最少需要多少回合；若小力无法追到小扣，请返回 -1。
注意：小力和小扣一定会采取最优移动策略。
提示：
edges 的长度等于图中节点个数
3 <= edges.length <= 10^5
1 <= edges[i][0], edges[i][1] <= edges.length 且 edges[i][0] != edges[i][1]
1 <= startA, startB <= edges.length 且 startA != startB
 */