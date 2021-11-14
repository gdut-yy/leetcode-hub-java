import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // 入度
        int[] inDegrees = new int[numCourses];
        // 其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
        for (int[] prerequisite : prerequisites) {
            inDegrees[prerequisite[0]]++;

            // bi => ai1, ai2...
            List<Integer> biList = graph.getOrDefault(prerequisite[1], new ArrayList<>());
            biList.add(prerequisite[0]);
            graph.put(prerequisite[1], biList);
        }

        // 入度为 0 进队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> resList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.remove();
            resList.add(course);
            for (int next : graph.getOrDefault(course, new ArrayList<>())) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.add(next);
                }
            }
        }
        // 如果不可能完成所有课程，返回 一个空数组 。
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
 */