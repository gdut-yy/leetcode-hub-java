import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution1136 {
    public int minimumSemesters(int n, int[][] relations) {
        // 拓扑排序
        Map<Integer, Set<Integer>> outGraph = new HashMap<>();
        Map<Integer, Set<Integer>> inGraph = new HashMap<>();
        // 课程关系表 relations[i] = [X, Y]，用以表示课程 X 和课程 Y 之间的先修关系：课程 X 必须在课程 Y 之前修完。
        for (int[] relation : relations) {
            int pre = relation[0];
            int cur = relation[1];

            Set<Integer> outSet = outGraph.getOrDefault(pre, new HashSet<>());
            outSet.add(cur);
            outGraph.put(pre, outSet);

            Set<Integer> inSet = inGraph.getOrDefault(cur, new HashSet<>());
            inSet.add(pre);
            inGraph.put(cur, inSet);
        }

        // 入度为 0 进队列
        Queue<Integer> queue = new LinkedList<>();
        // 它们以 1 到 N 进行编号。
        for (int i = 1; i <= n; i++) {
            if (inGraph.getOrDefault(i, new HashSet<>()).size() == 0) {
                queue.add(i);
            }
        }
        // 统计学期
        int level = 0;
        // 统计课程数
        int cnt = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cnt++;
                int cur = queue.remove();
                for (int next : outGraph.getOrDefault(cur, new HashSet<>())) {
                    inGraph.get(next).remove(cur);
                    if (inGraph.get(next).size() == 0) {
                        queue.add(next);
                    }
                }
            }
        }
        return cnt == n ? level : -1;
    }
}
/*
$1136. 平行课程
https://leetcode-cn.com/problems/parallel-courses/

第 5 场双周赛 T4。

已知有 N 门课程，它们以 1 到 N 进行编号。
给你一份课程关系表 relations[i] = [X, Y]，用以表示课程 X 和课程 Y 之间的先修关系：课程 X 必须在课程 Y 之前修完。
假设在一个学期里，你可以学习任何数量的课程，但前提是你已经学习了将要学习的这些课程的所有先修课程。
请你返回学完全部课程所需的最少学期数。
如果没有办法做到学完全部这些课程的话，就返回 -1。
提示：
1 <= N <= 5000
1 <= relations.length <= 5000
relations[i][0] != relations[i][1]
输入中没有重复的关系

拓扑排序。
 */