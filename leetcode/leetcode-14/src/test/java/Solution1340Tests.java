import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1340Tests {
    private final Solution1340 solution1340 = new Solution1340();

    @Test
    public void example1() {
        int[] arr = {6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};
        int d = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution1340.maxJumps(arr, d));
    }

    @Test
    public void example2() {
        int[] arr = {3, 3, 3, 3, 3};
        int d = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution1340.maxJumps(arr, d));
    }

    @Test
    public void example3() {
        int[] arr = {7, 6, 5, 4, 3, 2, 1};
        int d = 1;
        int expected = 7;
        Assertions.assertEquals(expected, solution1340.maxJumps(arr, d));
    }

    @Test
    public void example4() {
        int[] arr = {7, 1, 7, 1, 7, 1};
        int d = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution1340.maxJumps(arr, d));
    }

    @Test
    public void example5() {
        int[] arr = {66};
        int d = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution1340.maxJumps(arr, d));
    }
}