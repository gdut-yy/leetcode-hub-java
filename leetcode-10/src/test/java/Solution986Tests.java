import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution986Tests {
    private final Solution986 solution986 = new Solution986();

    @Test
    public void example1() {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] expected = {{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}};
        Assertions.assertArrayEquals(expected, solution986.intervalIntersection(firstList, secondList));
    }

    @Test
    public void example2() {
        int[][] firstList = {{1, 3}, {5, 9}};
        int[][] secondList = {};
        int[][] expected = {};
        Assertions.assertArrayEquals(expected, solution986.intervalIntersection(firstList, secondList));
    }

    @Test
    public void example3() {
        int[][] firstList = {};
        int[][] secondList = {{4, 8}, {10, 12}};
        int[][] expected = {};
        Assertions.assertArrayEquals(expected, solution986.intervalIntersection(firstList, secondList));
    }

    @Test
    public void example4() {
        int[][] firstList = {{1, 7}};
        int[][] secondList = {{3, 10}};
        int[][] expected = {{3, 7}};
        Assertions.assertArrayEquals(expected, solution986.intervalIntersection(firstList, secondList));
    }
}
