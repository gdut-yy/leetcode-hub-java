import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3661Tests {
    private final Solution3661 solution3661 = new Solution3661();

    @Test
    public void example1() {
        int[] robots = {4};
        int[] distance = {3};
        int[] walls = {1, 10};
        int expected = 1;
        Assertions.assertEquals(expected, solution3661.maxWalls(robots, distance, walls));
    }

    @Test
    public void example2() {
        int[] robots = {10, 2};
        int[] distance = {5, 1};
        int[] walls = {5, 2, 7};
        int expected = 3;
        Assertions.assertEquals(expected, solution3661.maxWalls(robots, distance, walls));
    }

    @Test
    public void example3() {
        int[] robots = {1, 2};
        int[] distance = {100, 1};
        int[] walls = {10};
        int expected = 0;
        Assertions.assertEquals(expected, solution3661.maxWalls(robots, distance, walls));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/maximum-walls-destroyed-by-robots/submissions/655939484/
        int[] robots = {31, 36, 18, 39, 10, 21, 40, 69, 57, 51, 19, 32, 50, 53, 3, 28, 9, 59, 46, 22, 13, 63, 33, 14, 25, 52, 64, 5, 44, 17, 68, 45};
        int[] distance = {5, 3, 4, 6, 3, 4, 2, 4, 6, 5, 4, 3, 1, 4, 3, 4, 5, 3, 1, 3, 2, 2, 4, 1, 3, 2, 4, 2, 2, 1, 4, 6};
        int[] walls = {10, 41, 54, 6, 7, 33, 14, 30, 9, 12, 38, 27, 39, 52, 42, 46, 45, 17, 2, 15, 55, 44, 4, 18, 20, 34, 28, 51, 11, 13, 37, 31, 23, 24, 5, 56, 22, 57, 35, 29, 32, 26, 48, 47, 16, 43, 36, 25, 53, 19, 40, 49, 21, 1, 50, 3, 8};
        int expected = 56;
        Assertions.assertEquals(expected, solution3661.maxWalls(robots, distance, walls));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/problems/maximum-walls-destroyed-by-robots/submissions/655951952/
        int[] robots = {12, 6, 34, 28, 58, 10, 42, 4, 55, 48, 3, 7, 26, 40, 54, 17, 32, 23, 56, 43, 31, 1, 24};
        int[] distance = {2, 5, 1, 6, 3, 8, 6, 4, 5, 6, 9, 3, 3, 8, 6, 3, 5, 7, 5, 7, 5, 7, 7};
        int[] walls = {25, 37, 48, 94, 56, 55, 30, 28, 40, 35, 15, 97, 12, 6, 85, 14, 52, 60, 27, 71, 5, 19, 73, 9, 92, 32, 11, 63, 13, 8, 39, 88, 44, 79, 7, 17, 78, 93, 33, 80, 26, 46, 68, 47, 95, 24, 36, 49, 90, 70, 64, 18, 57, 50, 66, 51, 54, 2, 21, 86, 16, 61, 91, 75, 58, 38, 65, 45, 29, 69, 3, 53, 1, 87, 83, 59, 23, 10, 62, 76, 43, 96, 77, 31, 4, 34, 42, 67, 89, 41, 82, 72, 22, 20, 81, 84, 74};
        int expected = 61;
        Assertions.assertEquals(expected, solution3661.maxWalls(robots, distance, walls));
    }
}