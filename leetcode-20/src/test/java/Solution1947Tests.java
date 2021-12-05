import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1947Tests {
    private final Solution1947 solution1947 = new Solution1947();

    @Test
    public void example1() {
        int[][] students = {{1, 1, 0}, {1, 0, 1}, {0, 0, 1}};
        int[][] mentors = {{1, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        int expected = 8;
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum(students, mentors));
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum2(students, mentors));
    }

    @Test
    public void example2() {
        int[][] students = {{0, 0}, {0, 0}, {0, 0}};
        int[][] mentors = {{1, 1}, {1, 1}, {1, 1}};
        int expected = 0;
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum(students, mentors));
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum2(students, mentors));
    }

    // 补充用例
    @Test
    public void example3() {
        int[][] students = {{0, 0, 1, 1, 1, 0, 1}, {0, 1, 1, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 1, 1}};
        int[][] mentors = {{0, 1, 1, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 1}, {0, 1, 0, 1, 0, 0, 1}, {1, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 0, 0}};
        int expected = 24;
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum(students, mentors));
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum2(students, mentors));
    }

    @Test
    public void example4() {
        int[][] students = {{0, 0, 1, 0, 1}, {1, 0, 1, 1, 1}};
        int[][] mentors = {{1, 0, 1, 0, 1}, {1, 0, 1, 1, 0}};
        int expected = 8;
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum(students, mentors));
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum2(students, mentors));
    }

    @Test
    public void example5() {
        int[][] students = {{1, 1, 1}, {0, 0, 1}, {0, 0, 1}, {0, 1, 0}};
        int[][] mentors = {{1, 0, 1}, {0, 1, 1}, {0, 1, 0}, {1, 1, 0}};
        int expected = 9;
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum(students, mentors));
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum2(students, mentors));
    }

    @Test
    public void example6() {
        int[][] students = {{0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 0, 1}, {1, 0, 1, 1, 0, 0}};
        int[][] mentors = {{1, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 1}};
        int expected = 10;
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum(students, mentors));
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum2(students, mentors));
    }

    @Test
    public void example7() {
        int[][] students = {{1, 0, 0, 0, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 0, 1}, {1, 0, 1, 1, 1, 0, 1, 1}, {0, 0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {1, 0, 0, 0, 0, 0, 0, 1}};
        int[][] mentors = {{1, 1, 0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 0, 0, 1, 0}, {1, 1, 1, 0, 1, 0, 1, 0}, {1, 0, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 1, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 0, 0, 0, 1}};
        int expected = 40;
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum(students, mentors));
        Assertions.assertEquals(expected, solution1947.maxCompatibilitySum2(students, mentors));
    }
}
