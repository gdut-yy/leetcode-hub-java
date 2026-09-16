import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4025Tests {
    private final Solution4025 solution4025 = new Solution4025();

    @Test
    public void example1() {
        int period = 8;
        int[] lights = {2, 3};
        int[] arrivalTime = {2, 5, 8, 11};
        int expected = 5;
        Assertions.assertEquals(expected, solution4025.minPenalty(period, lights, arrivalTime));
    }

    @Test
    public void example2() {
        int period = 10;
        int[] lights = {3, 6, 8};
        int[] arrivalTime = {4, 9, 15};
        int expected = 1;
        Assertions.assertEquals(expected, solution4025.minPenalty(period, lights, arrivalTime));
    }

    @Test
    public void example3() {
        int period = 5;
        int[] lights = {2};
        int[] arrivalTime = {2, 3, 4, 5, 6};
        int expected = 3;
        Assertions.assertEquals(expected, solution4025.minPenalty(period, lights, arrivalTime));
    }
}