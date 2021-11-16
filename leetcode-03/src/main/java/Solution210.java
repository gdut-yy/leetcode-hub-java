import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 拓扑排序
        Map<Integer, Set<Integer>> outGraph = new HashMap<>();
        Map<Integer, Set<Integer>> inGraph = new HashMap<>();
        // 其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
        for (int[] prerequisite : prerequisites) {
            int pre = prerequisite[1];
            int cur = prerequisite[0];

            Set<Integer> outSet = outGraph.getOrDefault(pre, new HashSet<>());
            outSet.add(cur);
            outGraph.put(pre, outSet);

            Set<Integer> inSet = inGraph.getOrDefault(cur, new HashSet<>());
            inSet.add(pre);
            inGraph.put(cur, inSet);
        }

        // 入度为 0 进队列 记为 0 到 numCourses - 1
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inGraph.getOrDefault(i, new HashSet<>()).size() == 0) {
                queue.add(i);
            }
        }
        List<Integer> resList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            resList.add(cur);
            for (int next : outGraph.getOrDefault(cur, new HashSet<>())) {
                inGraph.get(next).remove(cur);
                if (inGraph.get(next).size() == 0) {
                    queue.add(next);
                }
            }
        }
        if (resList.size() == numCourses) {
            return resList.stream().mapToInt(i -> i).toArray();
        }
        return new int[]{};
    }
}
/*
210. 课程表 II
https://leetcode-cn.com/problems/course-schedule-ii/

现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，
表示在选修课程 ai 前 必须 先选修 bi 。
例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。

拓扑排序。
相似题目: 207. 课程表
https://leetcode-cn.com/problems/course-schedule/
 */