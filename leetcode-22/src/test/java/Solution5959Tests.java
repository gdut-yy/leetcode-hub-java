import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5959Tests {
    private final Solution5959 solution5959 = new Solution5959();

    @Test
    public void example1() {
        int[] arr = {5, 4, 3, 2, 1};
        int k = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution5959.kIncreasing(arr, k));
    }

    @Test
    public void example2() {
        int[] arr = {4, 1, 5, 2, 6, 2};
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution5959.kIncreasing(arr, k));
    }

    @Test
    public void example3() {
        int[] arr = {4, 1, 5, 2, 6, 2};
        int k = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution5959.kIncreasing(arr, k));
    }

    // 补充用例
    @Test
    public void example4() {
        int[] arr = {12, 6, 12, 6, 14, 2, 13, 17, 3, 8, 11, 7, 4, 11, 18, 8, 8, 3};
        int k = 1;
        int expected = 12;
        Assertions.assertEquals(expected, solution5959.kIncreasing(arr, k));
    }    // 补充用例

    @Test
    public void example5() {
        int[] arr = {2, 2, 2, 2, 2, 1, 1, 4, 4, 3, 3, 3, 3, 3};
        int k = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution5959.kIncreasing(arr, k));
    }

    @Test
    public void example6() {
        int[] arr = {19, 59, 59, 52, 33, 24, 57, 11, 16, 50, 33, 31, 64, 61, 59, 4, 15, 53, 56, 36, 2, 23, 48, 31, 59, 23, 56, 11, 43, 33, 51, 63, 1, 48, 61, 38, 30, 35, 45, 61, 9, 44, 1, 45, 19, 19, 53, 21, 54, 66, 63, 10, 48, 61, 50, 64, 47, 35, 44, 33, 11, 60, 65, 61, 50, 54};
        int k = 32;
        int expected = 16;
        Assertions.assertEquals(expected, solution5959.kIncreasing(arr, k));
    }
}