import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP2590Tests {
    @Test
    public void example1() {
        SolutionP2590.TodoList todoList = new SolutionP2590.TodoList();

        // 返回1。为ID为1的用户添加一个新任务。
        Assertions.assertEquals(1, todoList.addTask(1, "Task1", 50, List.of()));

        // 返回2。为ID为1的用户添加另一个任务，并给它添加标签“P1”。
        Assertions.assertEquals(2, todoList.addTask(1, "Task2", 100, List.of("P1")));

        // 返回["Task1", "Task2"]。用户1目前有两个未完成的任务。
        Assertions.assertEquals(List.of("Task1", "Task2"), todoList.getAllTasks(1));

        // 返回[]。用户5目前没有任务。
        Assertions.assertEquals(List.of(), todoList.getAllTasks(5));

        // 返回3。为ID为1的用户添加另一个任务，并给它添加标签“P1”。
        Assertions.assertEquals(3, todoList.addTask(1, "Task3", 30, List.of("P1")));

        // 返回["Task3", "Task2"]。返回ID为1的用户未完成的带有“P1”标签的任务。
        Assertions.assertEquals(List.of("Task3", "Task2"), todoList.getTasksForTag(1, "P1"));

        // 不做任何操作，因为任务1不属于用户5。
        todoList.completeTask(5, 1);

        // 将任务2标记为已完成。
        todoList.completeTask(1, 2);

        // 返回["Task3"]。返回ID为1的用户未完成的带有“P1”标签的任务。
        // 注意，现在不包括 “Task2” ，因为它已经被标记为已完成。
        Assertions.assertEquals(List.of("Task3"), todoList.getTasksForTag(1, "P1"));

        // 返回["Task3", "Task1"]。用户1现在有两个未完成的任务。
        Assertions.assertEquals(List.of("Task3", "Task1"), todoList.getAllTasks(1));
    }
}