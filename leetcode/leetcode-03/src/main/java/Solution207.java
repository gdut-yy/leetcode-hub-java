import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : prerequisites) {
            int x = p[1], y = p[0];
            g[x].add(y);
        }

        int[] colors = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (colors[i] == 0 && dfs(i, g, colors)) return false; // 有环
        }
        return true; // 没有环
    }

    private boolean dfs(int x, List<Integer>[] g, int[] colors) {
        colors[x] = 1; // x 正在访问中
        for (int y : g[x]) {
            if (colors[y] == 1) return true;
            if (colors[y] == 0 && dfs(y, g, colors)) return true;
        }
        colors[x] = 2; // x 完全访问完毕
        return false; // 没有找到环
    }
}
/*
207. 课程表
https://leetcode.cn/problems/course-schedule/

你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，
表示如果要学习课程 ai 则 必须 先学习课程  bi 。
例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
提示：
1 <= numCourses <= 10^5
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
prerequisites[i] 中的所有课程对 互不相同

三色标记法 判环
0 没有遍历过
1 正在遍历中
2 遍历过了
另有 拓扑排序 解法。
相似题目: 210. 课程表 II
https://leetcode.cn/problems/course-schedule-ii/
 */