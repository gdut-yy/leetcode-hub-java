import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3538Tests {
    private final Solution3538 solution3538 = new Solution3538();

    @Test
    public void example1() {
        int l = 10;
        int n = 4;
        int k = 1;
        int[] position = {0, 3, 8, 10};
        int[] time = {5, 8, 3, 6};
        int expected = 62;
        Assertions.assertEquals(expected, solution3538.minTravelTime(l, n, k, position, time));
    }

    @Test
    public void example2() {
        int l = 5;
        int n = 5;
        int k = 1;
        int[] position = {0, 1, 2, 3, 5};
        int[] time = {8, 3, 9, 3, 3};
        int expected = 34;
        Assertions.assertEquals(expected, solution3538.minTravelTime(l, n, k, position, time));
    }
}