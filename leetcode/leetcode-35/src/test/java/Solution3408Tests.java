import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3408Tests {
    @Test
    public void example1() {
        List<List<Integer>> tasks = UtUtils.stringToIntegerList2("[[1, 101, 10], [2, 102, 20], [3, 103, 15]]");

        // 分别给用户 1 ，2 和 3 初始化一个任务。
        Solution3408.TaskManager taskManager = new Solution3408.TaskManager(tasks);

        // 给用户 4 添加优先级为 5 的任务 104 。
        taskManager.add(4, 104, 5);

        // 更新任务 102 的优先级为 8 。
        taskManager.edit(102, 8);

        // 返回 3 。执行用户 3 的任务 103 。
        Assertions.assertEquals(3, taskManager.execTop());

        // 将系统中的任务 101 删除。
        taskManager.rmv(101);

        // 给用户 5 添加优先级为 15 的任务 105 。
        taskManager.add(5, 105, 15);

        // 返回 5 。执行用户 5 的任务 105 。
        Assertions.assertEquals(5, taskManager.execTop());
    }
}