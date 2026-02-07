import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class SolutionP3383 {
    private ArrayList<Integer>[] g;
    private boolean[] vis;
    private int[] sid, dfn;
    private int sccCnt, dfsClock;
    private Deque<Integer> st;

    public int minRunesToAdd(int n, int[] crystals, int[] flowFrom, int[] flowTo) {
        // 先标记所有能访问到的点
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < flowFrom.length; i++) {
            g[flowFrom[i]].add(flowTo[i]);
        }
        vis = new boolean[n];
        for (int v : crystals) {
            if (!vis[v]) {
                dfs(v);
            }
        }

        // 剩余未访问的点，跑 Tarjan SCC 算法
        // low(v) 定义为以下两种情况的最小值
        // 1. dfn[v]
        // 2. subtree(v) 的返祖边所指向的节点的 dfn，也就是经过恰好一条不在 DFS 树上的边，能够到达 subtree(v) 的节点的 dfn
        sid = new int[n];
        sccCnt = 0;
        dfn = new int[n];
        dfsClock = 0;
        st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (dfn[i] == 0 && !vis[i]) {
                tarjan(i);
            }
        }

        // 统计缩点后的图的节点入度
        int[] inDeg = new int[sccCnt];
        for (int i = 0; i < flowFrom.length; i++) {
            int from = flowFrom[i];
            int to = flowTo[i];
            if (!vis[to] && sid[from] != sid[to]) {
                inDeg[sid[to]]++;
            }
        }
        // 入度为 0 的点，一定要放置魔法水晶
        int ans = 0;
        for (int d : inDeg) {
            if (d == 0) {
                ans++;
            }
        }
        return ans;
    }

    private void dfs(int v) {
        vis[v] = true;
        for (int w : g[v]) {
            if (!vis[w]) {
                dfs(w);
            }
        }
    }

    private int tarjan(int v) {
        dfsClock++;
        dfn[v] = dfsClock;
        int lowV = dfsClock;
        st.push(v);
        for (int w : g[v]) {
            if (vis[w]) continue;
            if (dfn[w] == 0) {
                int lowW = tarjan(w);
                lowV = Math.min(lowV, lowW);
            } else {
                // 如果 0 < dfn[w] != inf，说明 w 在 st 中，那么找到 v 的到其祖先节点的边 v-w，用 dfn[w] 来更新 lowV
                // 实际上，不需要判断 dfn[w] == inf 的情况，直接取 min 即可
                lowV = Math.min(lowV, dfn[w]);
            }
        }
        if (dfn[v] == lowV) { // 无法到达 v 的任一祖先
            while (true) {
                int w = st.pop();
                // 避免搜索树上的另一棵子树上的点 v，通过横向边，把 dfn[w] 错误地更新到 lowV（注意 dfn[w] 都小于后面新遍历到的点的 dfn 值）
                dfn[w] = Integer.MAX_VALUE; // 相当于 inStack[w] = false
                sid[w] = sccCnt; // 缩点
                if (w == v) break;
            }
            sccCnt++;
        }
        return lowV;
    }
}
/*
$3383. 施法所需最低符文数量
https://leetcode.cn/problems/minimum-runes-to-add-to-cast-spell/description/

Alice 刚刚从巫师学校毕业，并且希望施展一个魔法咒语来庆祝。魔法咒语包含某些需要集中魔力的焦点，其中一些焦点含有作为咒语能量源的魔法水晶。焦点可以通过 有向符文 进行连接，这些符文将魔力流从一个焦点传输到另一个焦点。
给定一个整数 n 表示焦点的数量，以及一个整数数组 crystals，其中 crystals[i] 表示有魔法水晶的焦点。同时给定两个整数数组 flowFrom 和 flowTo，表示存在的 有向符文。第 ith 个符文允许魔力流从焦点 flowFrom[i] 传输到焦点 flowTo[i]。
你需要找到 Alice 必须添加到她的咒语中的定向符文数量，使得每个焦点要么：
- 包含 一个魔法水晶。
- 从其它焦点 接收 魔力流。
返回她所需要添加的 最少 有向符文数量。
提示：
2 <= n <= 10^5
1 <= crystals.length <= n
0 <= crystals[i] <= n - 1
1 <= flowFrom.length == flowTo.length <= min(2 * 10^5, (n * (n - 1)) / 2)
0 <= flowFrom[i], flowTo[i] <= n - 1
flowFrom[i] != flowTo[i]
所有的有向符文 互不相同。

强连通分量 + 缩点 https://leetcode.cn/problems/minimum-runes-to-add-to-cast-spell/solutions/3014736/qiang-lian-tong-fen-liang-suo-dian-by-en-clok/
 */