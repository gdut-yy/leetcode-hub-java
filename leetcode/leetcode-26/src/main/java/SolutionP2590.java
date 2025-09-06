import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP2590 {
    static class TodoList {
        int taskId;
        Map<Integer, List<Task>> userTasks;

        record Task(int taskId, String taskDesc, int dueDate, List<String> tags) {
        }

        public TodoList() {
            taskId = 0;
            userTasks = new HashMap<>(); // userId -> tasks
        }

        public int addTask(int userId, String taskDescription, int dueDate, List<String> tags) {
            userTasks.computeIfAbsent(userId, e -> new ArrayList<>()).add(new Task(++taskId, taskDescription, dueDate, tags));
            return taskId;
        }

        public List<String> getAllTasks(int userId) {
            List<Task> allTasks = userTasks.getOrDefault(userId, new ArrayList<>());
            allTasks.sort(Comparator.comparingInt(a -> a.dueDate));
            return allTasks.stream().map(task -> task.taskDesc).toList();
        }

        public List<String> getTasksForTag(int userId, String tag) {
            List<Task> allTasks = new ArrayList<>(userTasks.getOrDefault(userId, new ArrayList<>()).stream().filter(task -> task.tags.contains(tag)).toList());
            allTasks.sort(Comparator.comparingInt(a -> a.dueDate));
            return allTasks.stream().map(task -> task.taskDesc).toList();
        }

        public void completeTask(int userId, int taskId) {
            userTasks.getOrDefault(userId, new ArrayList<>()).removeIf(task -> task.taskId == taskId);
        }
    }
}
/*
$2590. 设计一个待办事项清单
https://leetcode.cn/problems/design-a-todo-list/description/

设计一个待办事项清单，用户可以添加 任务 ，标记任务为 完成状态 ，或获取待办任务列表。用户还可以为任务添加 标签 ，并可以按照特定标签筛选任务。
实现 TodoList 类：
- TodoList() 初始化对象。
- int addTask(int userId, String taskDescription, int dueDate, List<String> tags) 为用户 ID 为 userId 的用户添加一个任务，该任务的到期日期为 dueDate ，附带了一个标签列表 tags 。返回值为任务的 ID 。该 ID 从 1 开始，依次 递增。即，第一个任务的ID应为 1 ，第二个任务的 ID 应为 2 ，以此类推。
- List<String> getAllTasks(int userId) 返回未标记为完成状态的 ID 为 userId 的用户的所有任务列表，按照到期日期排序。如果用户没有未完成的任务，则应返回一个空列表。
- List<String> getTasksForTag(int userId, String tag) 返回 ID 为 userId 的用户未标记为完成状态且具有 tag 标签之一的所有任务列表，按照到期日期排序。如果不存在此类任务，则返回一个空列表。
- void completeTask(int userId, int taskId) 仅在任务存在且 ID 为 userId 的用户拥有此任务且它是未完成状态时，将 ID 为 taskId 的任务标记为已完成状态。
提示：
1 <= userId, taskId, dueDate <= 100
0 <= tags.length <= 100
1 <= taskDescription.length <= 50
1 <= tags[i].length, tag.length <= 20
所有的 dueDate 值都是唯一的。
所有字符串都由小写和大写英文字母和数字组成。
每个方法最多被调用 100 次。

哈希表模拟
 */