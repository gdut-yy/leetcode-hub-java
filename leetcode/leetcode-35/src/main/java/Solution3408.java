import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution3408 {
    static class TaskManager {
        Map<Integer, Integer> taskId_priority = new HashMap<>();
        Map<Integer, Integer> taskId_userId = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> priority_taskIds = new TreeMap<>(Comparator.reverseOrder());

        public TaskManager(List<List<Integer>> tasks) {
            for (List<Integer> p : tasks) {
                int userId = p.get(0), taskId = p.get(1), priority = p.get(2);
                add(userId, taskId, priority);
            }
        }

        public void add(int userId, int taskId, int priority) {
            taskId_priority.put(taskId, priority);
            taskId_userId.put(taskId, userId);
            priority_taskIds.computeIfAbsent(priority, e -> new TreeSet<>(Comparator.reverseOrder())).add(taskId);
        }

        public void edit(int taskId, int newPriority) {
            Integer userId = taskId_userId.get(taskId);
            rmv(taskId);
            add(userId, taskId, newPriority);
        }

        public void rmv(int taskId) {
            Integer priority = taskId_priority.get(taskId);
            taskId_priority.remove(taskId);
            taskId_userId.remove(taskId);
            priority_taskIds.get(priority).remove(taskId);
            if (priority_taskIds.get(priority).isEmpty()) priority_taskIds.remove(priority);

        }

        public int execTop() {
            if (priority_taskIds.isEmpty()) return -1;
            Map.Entry<Integer, TreeSet<Integer>> firstEntry = priority_taskIds.firstEntry();
            Integer key = firstEntry.getKey();
            TreeSet<Integer> priorities = firstEntry.getValue();
            Integer taskId = priorities.removeFirst();
            if (priorities.isEmpty()) priority_taskIds.remove(key);
            return taskId_userId.get(taskId);
        }
    }
}
/*
3408. 设计任务管理器
https://leetcode.cn/problems/design-task-manager/description/

第 147 场双周赛 T2。

一个任务管理器系统可以让用户管理他们的任务，每个任务有一个优先级。这个系统需要高效地处理添加、修改、执行和删除任务的操作。
请你设计一个 TaskManager 类：
- TaskManager(vector<vector<int>>& tasks) 初始化任务管理器，初始化的数组格式为 [userId, taskId, priority] ，表示给 userId 添加一个优先级为 priority 的任务 taskId 。
- void add(int userId, int taskId, int priority) 表示给用户 userId 添加一个优先级为 priority 的任务 taskId ，输入 保证 taskId 不在系统中。
- void edit(int taskId, int newPriority) 更新已经存在的任务 taskId 的优先级为 newPriority 。输入 保证 taskId 存在于系统中。
- void rmv(int taskId) 从系统中删除任务 taskId 。输入 保证 taskId 存在于系统中。
- int execTop() 执行所有用户的任务中优先级 最高 的任务，如果有多个任务优先级相同且都为 最高 ，执行 taskId 最大的一个任务。执行完任务后，taskId 从系统中 删除 。同时请你返回这个任务所属的用户 userId 。如果不存在任何任务，返回 -1 。
注意 ，一个用户可能被安排多个任务。
提示：
1 <= tasks.length <= 10^5
0 <= userId <= 10^5
0 <= taskId <= 10^5
0 <= priority <= 10^9
0 <= newPriority <= 10^9
add ，edit ，rmv 和 execTop 的总操作次数 加起来 不超过 2 * 10^5 次。

哈希表 + 平衡树。
时间复杂度：
初始化：O(nlogn)，其中 n 是 tasks 的长度。
add、edit、rmv 和 execTop：O(log(n+q))，其中 q 是 add 和 edit 的调用次数之和。
 */