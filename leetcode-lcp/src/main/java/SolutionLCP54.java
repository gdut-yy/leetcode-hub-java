import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SolutionLCP54 {
    private static final int S = 0;
    private Map<Integer, List<Integer>> adj;
    private boolean[] isCut;
    private int[] dfn;
    private int[] low;
    private int clk;
    private Deque<Integer> stk;
    private LinkedList<List<Integer>> dcc;

    public long minimumCost(int[] cost, int[][] roads) {
        int n = cost.length;
        if (n == 1) {
            return cost[0];
        }

        adj = new HashMap<>();
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], key -> new ArrayList<>()).add(road[1]);
            adj.computeIfAbsent(road[1], key -> new ArrayList<>()).add(road[0]);
        }
        isCut = new boolean[n];
        dfn = new int[n];
        low = new int[n];
        clk = 0;
        stk = new ArrayDeque<>();
        dcc = new LinkedList<>();
        tarjan(S);

        // 整张图是一个双连通分量，选择整张图权值最小的点即可
        if (dcc.size() == 1) {
            return Arrays.stream(cost).min().orElseThrow();
        }

        List<Integer> vec = new ArrayList<>();
        for (List<Integer> c : dcc) {
            int cnt = 0;
            int min = Integer.MAX_VALUE;
            for (int x : c) {
                if (isCut[x]) {
                    cnt++;
                } else {
                    min = Math.min(min, cost[x]);
                }
            }
            // 该双连通分量只和一个割点相连，是缩点形成的树的叶子节点
            if (cnt == 1) {
                vec.add(min);
            }
        }

        Collections.sort(vec);
        long res = 0;
        for (int i = 0; i < vec.size() - 1; i++) {
            res += vec.get(i);
        }
        return res;
    }

    private void tarjan(int sn) {
        dfn[sn] = low[sn] = ++clk;
        stk.push(sn);
        int flag = 0;
        for (int fn : adj.getOrDefault(sn, new ArrayList<>())) {
            if (dfn[fn] == 0) {
                tarjan(fn);
                low[sn] = Math.min(low[sn], low[fn]);
                if (low[fn] >= dfn[sn]) {
                    flag++;
                    if (sn != S || flag > 1) {
                        isCut[sn] = true;
                    }

                    int t;
                    dcc.add(new ArrayList<>());
                    do {
                        t = stk.pop();
                        dcc.getLast().add(t);
                    } while (t != fn);
                    dcc.getLast().add(sn);
                }
            } else {
                low[sn] = Math.min(low[sn], dfn[fn]);
            }
        }
    }
}
/*
LCP 54. 夺回据点
https://leetcode.cn/problems/s5kipK/

LCCUP 力扣杯 2022 春季编程大赛个人赛 T5。

欢迎各位勇者来到力扣城，本次试炼主题为「夺回据点」。
魔物了占领若干据点，这些据点被若干条道路相连接，roads[i] = [x, y] 表示编号 x、y 的两个据点通过一条道路连接。
现在勇者要将按照以下原则将这些据点逐一夺回：
- 在开始的时候，勇者可以花费资源先夺回一些据点，初始夺回第 j 个据点所需消耗的资源数量为 cost[j]
- 接下来，勇者在不消耗资源情况下，每次可以夺回一个和「已夺回据点」相连接的魔物据点，并对其进行夺回
注：为了防止魔物暴动，勇者在每一次夺回据点后（包括花费资源夺回据点后），需要保证剩余的所有魔物据点之间是相连通的（不经过「已夺回据点」）。
请返回勇者夺回所有据点需要消耗的最少资源数量。
注意：
输入保证初始所有据点都是连通的，且不存在重边和自环
提示：
1 <= roads.length, cost.length <= 10^5
0 <= roads[i][0], roads[i][1] < cost.length
1 <= cost[i] <= 10^9

点双连通分量缩点 https://leetcode.cn/problems/s5kipK/solution/by-tsreaper-z8by/
 */