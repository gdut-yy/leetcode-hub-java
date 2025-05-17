import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution3547 {
    record Component(int isCycle, int size) {
    }

    private List<Integer>[] g;
    private boolean[] vis;
    private int cntV, cntE;

    public long maxScore(int n, int[][] edges) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        List<Component> components = new ArrayList<>();
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                cntV = 0;
                cntE = 0;
                dfs(i);
                int isCycle = cntE / 2 == cntV ? 1 : 0;
                components.add(new Component(isCycle, cntV));
            }
        }
        components.sort((a, b) -> {
            if (a.isCycle == b.isCycle) {
                return Integer.compare(b.size, a.size);
            }
            return Integer.compare(b.isCycle, a.isCycle);
        });

        int num = n;
        long totalScore = 0;
        for (Component comp : components) {
            int k = comp.size;
            boolean isCycle = comp.isCycle == 1;

            // 构造排列
            Deque<Integer> dq = new ArrayDeque<>();
            boolean left = true;
            for (int i = 0; i < k; i++) {
                if (left) {
                    dq.addFirst(num);
                } else {
                    dq.addLast(num);
                }
                num--;
                left = !left;
            }
            List<Integer> arranged = new ArrayList<>(dq);

            // 计算分数
            if (isCycle) {
                long score = 0;
                for (int i = 0; i < k; i++) {
                    int next = (i + 1) % k;
                    score += (long) arranged.get(i) * arranged.get(next);
                }
                totalScore += score;
            } else {
                long score = 0;
                for (int i = 0; i < k - 1; i++) {
                    score += (long) arranged.get(i) * arranged.get(i + 1);
                }
                totalScore += score;
            }
        }

        return totalScore;
    }

    private void dfs(int x) {
        vis[x] = true;
        cntV++;
        cntE += g[x].size();
        for (int y : g[x]) {
            if (vis[y]) continue;
            dfs(y);
        }
    }

    static class V2 {
        // O(1)
        // https://leetcode.cn/problems/maximum-sum-of-edge-values-in-a-graph/solutions/3673945/tan-xin-san-tiao-fa-ze-pythonjavacgo-by-0viop/
        public long maxScore(int n, int[][] edges) {
            long ans = ((long) n * n * 2 + n * 5 - 6) * (n - 1) / 6;
            if (n == edges.length) { // 环
                ans += 2;
            }
            return ans;
        }
    }
}
/*
3547. 图中边值的最大和
https://leetcode.cn/problems/maximum-sum-of-edge-values-in-a-graph/description/

第 449 场周赛 T3。

给你一个包含 n 个节点的 无向图，节点按从 0 到 n - 1 编号。每个节点 最多 与其他两个节点相连。
图中包含 m 条边，使用一个二维数组 edges 表示，其中 edges[i] = [ai, bi] 表示节点 ai 和节点 bi 之间有一条边。
你需要为每个节点分配一个从 1 到 n 的 唯一 值。边的值定义为其两端节点值的 乘积 。
你的得分是图中所有边值的总和。
返回你可以获得的 最大 得分。
提示：
1 <= n <= 5 * 10^4
m == edges.length
1 <= m <= n
edges[i].length == 2
0 <= ai, bi < n
ai != bi
图中不存在重复边。
图是连通的。
每个节点最多与其他两个节点相连。

因为题目出错不知道起什么标题。
评论区有人给出了如下数据：
11
[[0,1],[1,2],[2,3],[5,6],[6,7]]
这个数据预期结果是 366，但实际上可以构造 9-11-10-7 和 5-8-6 两条链，算出结果是 367。
rating 2366 (clist.by)
 */