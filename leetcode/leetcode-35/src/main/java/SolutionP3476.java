import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP3476 {
    public long maxProfit(int[] workers, int[][] tasks) {
        Map<Integer, List<Integer>> groupTasks = new HashMap<>(); // 按 task[0] 分组
        for (int[] ta : tasks) groupTasks.computeIfAbsent(ta[0], e -> new ArrayList<>()).add(ta[1]);
        for (List<Integer> vals : groupTasks.values()) vals.sort(null);

        long ans = 0;
        for (int wo : workers) {
            if (!groupTasks.containsKey(wo)) continue;
            ans += groupTasks.get(wo).removeLast();
            if (groupTasks.get(wo).isEmpty()) groupTasks.remove(wo);
        }
        int maxTask = 0;
        for (List<Integer> vals : groupTasks.values()) {
            maxTask = Math.max(maxTask, vals.getLast());
        }
        return ans + maxTask;
    }
}
/*
$3476. 最大化任务分配的利润
https://leetcode.cn/problems/maximize-profit-from-task-assignment/description/

给定一个整数数组 workers，其中 workers[i] 表示第 i 个工人的技能等级。同时给定一个 2 维数组 tasks，其中：
- tasks[i][0] 表示完成任务所需的技能要求。
- tasks[i][1] 表示完成任务的收益。
每一个工人 最多 能完成一个任务，并且只有在他们的技能等级 等于 任务的技能要求时才能获取此任务。今天又有一名 额外 工人加入，他可以承接任何任务，无论 技能要求如何。
返回按照最优方式分配任务给工人所能获得的 最大 总利润。
提示：
1 <= workers.length <= 10^5
1 <= workers[i] <= 10^9
1 <= tasks.length <= 10^5
tasks[i].length == 2
1 <= tasks[i][0], tasks[i][1] <= 10^9

分组 + 贪心。
时间复杂度 O(nlogn)。
 */