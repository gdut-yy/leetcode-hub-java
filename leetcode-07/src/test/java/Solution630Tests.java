import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution630Tests {
    private final Solution630 solution630 = new Solution630();

    @Test
    public void example1() {
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        int expected = 3;
        Assertions.assertEquals(expected, solution630.scheduleCourse(courses));
    }

    @Test
    public void example2() {
        int[][] courses = {{1, 2}};
        int expected = 1;
        Assertions.assertEquals(expected, solution630.scheduleCourse(courses));
    }

    @Test
    public void example3() {
        int[][] courses = {{3, 2}, {4, 3}};
        int expected = 0;
        Assertions.assertEquals(expected, solution630.scheduleCourse(courses));
    }

    // 补充用例
    @Test
    public void example4() {
        int[][] courses = {{7, 17}, {3, 12}, {10, 20}, {9, 10}, {5, 20}, {10, 19}, {4, 18}};
        int expected = 4;
        Assertions.assertEquals(expected, solution630.scheduleCourse(courses));
    }
}