import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1383Tests {
    private final Solution1383 solution1383 = new Solution1383();

    @Test
    public void example1() {
        int n = 6;
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        int k = 2;
        int expected = 60;
        Assertions.assertEquals(expected, solution1383.maxPerformance(n, speed, efficiency, k));
    }

    @Test
    public void example2() {
        int n = 6;
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        int k = 3;
        int expected = 68;
        Assertions.assertEquals(expected, solution1383.maxPerformance(n, speed, efficiency, k));
    }

    @Test
    public void example3() {
        int n = 6;
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        int k = 4;
        int expected = 72;
        Assertions.assertEquals(expected, solution1383.maxPerformance(n, speed, efficiency, k));
    }
}