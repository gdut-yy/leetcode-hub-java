import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        // 如果不可能完成所有课程，返回 一个空数组 。
        return resList.size() == numCourses;
    }
}
/*
207. 课程表
https://leetcode-cn.com/problems/course-schedule/

你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，
表示如果要学习课程 ai 则 必须 先学习课程  bi 。
例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。

拓扑排序。
相似题目: 210. 课程表 II
https://leetcode-cn.com/problems/course-schedule-ii/
 */