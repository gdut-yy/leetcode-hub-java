import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1066Tests {
    private final Solution1066 solution1066 = new Solution1066();

    @Test
    public void example1() {
        int[][] workers = {{0, 0}, {2, 1}};
        int[][] bikes = {{1, 2}, {3, 3}};
        int expected = 6;
        Assertions.assertEquals(expected, solution1066.assignBikes(workers, bikes));
    }

    @Test
    public void example2() {
        int[][] workers = {{0, 0}, {1, 1}, {2, 0}};
        int[][] bikes = {{1, 0}, {2, 2}, {2, 1}};
        int expected = 4;
        Assertions.assertEquals(expected, solution1066.assignBikes(workers, bikes));
    }

    // 补充用例
    @Test
    public void example3() {
        int[][] workers = {{0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}};
        int[][] bikes = {{0, 999}, {1, 999}, {2, 999}, {3, 999}, {4, 999}, {5, 999}, {6, 999}, {7, 999}, {8, 999}, {9, 999}};
        int expected = 4995;
        Assertions.assertEquals(expected, solution1066.assignBikes(workers, bikes));
    }

    @Test
    public void example4() {
        int[][] workers = {{239, 904}, {191, 103}, {260, 117}, {86, 78}, {747, 62}};
        int[][] bikes = {{660, 8}, {431, 772}, {78, 576}, {894, 481}, {451, 730}, {155, 28}};
        int expected = 1886;
        Assertions.assertEquals(expected, solution1066.assignBikes(workers, bikes));
    }
}