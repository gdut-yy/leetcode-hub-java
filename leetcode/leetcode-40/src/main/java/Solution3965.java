import java.util.ArrayList;
import java.util.List;

public class Solution3965 {
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        List<Integer>[] children = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            children[e[0]].add(e[1]);
        }

        long[] finish = new long[n];
        int[][] stack = new int[2 * n][];
        int top = 0;
        stack[top++] = new int[]{0, 0};
        while (top > 0) {
            int[] frame = stack[--top];
            int node = frame[0], state = frame[1];
            if (state == 0) {
                stack[top++] = new int[]{node, 1};
                List<Integer> ch = children[node];
                for (int i = ch.size() - 1; i >= 0; i--) {
                    stack[top++] = new int[]{ch.get(i), 0};
                }
            } else {
                List<Integer> ch = children[node];
                if (ch.isEmpty()) {
                    finish[node] = baseTime[node];
                } else {
                    long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
                    for (int child : ch) {
                        long f = finish[child];
                        min = Math.min(min, f);
                        max = Math.max(max, f);
                    }
                    finish[node] = max + (max - min + baseTime[node]);
                }
            }
        }
        return finish[0];
    }
}
/*
3965. 任务完成时间 I
https://leetcode.cn/problems/finish-time-of-tasks-i/description/

第 185 场双周赛 T3。

给你一个整数 n，表示项目中的任务数量，编号从 0 到 n - 1。这些任务以任务 0 为根的 树 的形式连接。这由一个长度为 n - 1 的二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示任务 ui 是任务 vi 的父节点。
同时给你一个长度为 n 的数组 baseTime，其中 baseTime[i] 表示完成任务 i 所需的时间。
每个任务的 完成时间 计算如下：
- 叶子任务：完成时间为 baseTime[i]。
- 非叶子任务：
  - 令 earliest 为其子节点中的 最小 完成时间，latest 为其子节点中的 最大 完成时间。
  - 令 ownDuration 为 (latest - earliest) + baseTime[i]。
  - 任务 i 的完成时间为 latest + ownDuration。
返回根任务 0 的完成时间。
提示：
1 <= n <= 10^5
edges.length = n - 1
edges[i] == [ui, vi]
0 <= ui, vi <= n - 1
ui != vi
输入保证 edges 表示一棵有效的树。
baseTime.length == n
1 <= baseTime[i] <= 10^5

自底向上 DFS。
时间复杂度 O(n)。
 */