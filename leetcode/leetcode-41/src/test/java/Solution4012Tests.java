import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4012Tests {
    private final Solution4012 solution4012 = new Solution4012();

    @Test
    public void example1() {
        int[] tasks = {1, 4, 4};
        int[] shifts = {9, 1, 4};
        int[] expected = {0, 2, 1};
        Assertions.assertArrayEquals(expected, solution4012.countTasks(tasks, shifts));
    }

    @Test
    public void example2() {
        int[] tasks = {2, 3, 4};
        int[] shifts = {20, 4, 5};
        int[] expected = {0, 2, 0};
        Assertions.assertArrayEquals(expected, solution4012.countTasks(tasks, shifts));
    }

    @Test
    public void example3() {
        int[] tasks = {4, 2};
        int[] shifts = {3, 6, 1};
        int[] expected = {2, 0, 2};
        Assertions.assertArrayEquals(expected, solution4012.countTasks(tasks, shifts));
    }
}