import java.util.ArrayList;
import java.util.List;

public class SolutionP3967 {
    // https://leetcode.cn/problems/finish-time-of-tasks-ii/solutions/3988228/liang-bian-dfsji-lu-ji-zhi-42xing-ji-jia-8dpt/
    private long[] has;          // 以 0 为根时，x 子树的完成时间
    private long[][] mxn;        // mxn[x] = {max1, max2, min1, min2}
    private long ans;
    private List<Integer>[] g;
    private int[] baseTime;

    public long finishTime(int n, int[][] edges, int[] baseTime) {
        if (n == 1) {
            return baseTime[0];
        }
        this.baseTime = baseTime;
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        has = new long[n];
        mxn = new long[n][4];
        dfs(0, -1);
        ans = has[0];
        dfs2(0, -1, 0);
        return ans;
    }

    /**
     * 第一遍：自底向上计算以 0 为根时每棵子树的完成时间
     */
    private long dfs(int x, int f) {
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE; // 最大、次大
        long c = Long.MAX_VALUE, d = Long.MAX_VALUE; // 次小、最小
        for (int s : g[x]) {
            if (s != f) {
                long v = dfs(s, x);
                if (v > a) {
                    b = a;
                    a = v;
                } else if (v > b) {
                    b = v;
                }
                if (v < d) {
                    c = d;
                    d = v;
                } else if (v < c) {
                    c = v;
                }
            }
        }
        mxn[x][0] = a;
        mxn[x][1] = b;
        mxn[x][2] = c;
        mxn[x][3] = d;
        has[x] = (a == Long.MIN_VALUE) ? baseTime[x] : a * 2 - d + baseTime[x];
        return has[x];
    }

    /**
     * 第二遍：换根，把父方向传下来的完成时间并入候选
     */
    private void dfs2(int x, int f, long newVal) {
        long a = mxn[x][0], b = mxn[x][1];
        long c = mxn[x][2], d = mxn[x][3];
        if (x != 0) {
            if (newVal > a) {
                b = a;
                a = newVal;
            } else if (newVal > b) {
                b = newVal;
            }
            if (newVal < d) {
                c = d;
                d = newVal;
            } else if (newVal < c) {
                c = newVal;
            }
        }
        ans = Math.min(ans, (a == Long.MIN_VALUE) ? baseTime[x] : a * 2 - d + baseTime[x]);
        for (int s : g[x]) {
            if (s != f) {
                long y = has[s];
                long na = (y < a) ? a : b; // 排除 y 后的最大
                long nd = (y > d) ? d : c; // 排除 y 后的最小
                if (x == 0 && g[0].size() == 1) {
                    dfs2(s, x, baseTime[0]);
                } else {
                    dfs2(s, x, 2 * na - nd + baseTime[x]);
                }
            }
        }
    }
}
/*
$3967. 任务完成时间 II
https://leetcode.cn/problems/finish-time-of-tasks-ii/description/

给你一个整数 n，表示项目中的任务数量，编号从 0 到 n - 1。这些任务以无向 树 的形式连接。这由一个长度为 n - 1 的二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示任务 ui 是任务 vi 的父节点。
同时给你一个长度为 n 的数组 baseTime，其中 baseTime[i] 表示完成任务 i 所需的时间。
每个任务的 完成时间 计算如下：
- 叶子任务：完成时间为 baseTime[i]。
- 非叶子任务：
  - 令 earliest 为其子节点中的 最小 完成时间，latest 为其子节点中的 最大 完成时间。
  - 令 ownDuration 为 (latest - earliest) + baseTime[i]。
  - 任务 i 的完成时间为 latest + ownDuration。
选择 任意 一个任务作为根节点，并根据上述规则计算该根节点的完成时间。
返回所有根选择中的 最小 可能完成时间。
示例 1：
输入：n = 3, edges = [[0,1],[1,2]], baseTime = [9,1,5]
输出：14
示例 2：
输入：n = 3, edges = [[0,1],[0,2]], baseTime = [4,7,6]
输出：12
示例 3：
输入：n = 4, edges = [[0,1],[0,2],[2,3]], baseTime = [5,8,2,1]
输出：16
提示：
1 <= n <= 10^5
edges.length = n - 1
edges[i] == [ui, vi]
0 <= ui, vi <= n - 1
ui != vi
输入保证 edges 表示一棵有效的无向树。
baseTime.length == n
1 <= baseTime[i] <= 10^5
 */