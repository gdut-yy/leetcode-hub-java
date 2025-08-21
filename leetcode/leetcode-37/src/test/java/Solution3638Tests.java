import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3638Tests {
    private final Solution3638 solution3638 = new Solution3638();

    @Test
    public void example1() {
        int[] weight = {2, 5, 1, 4, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution3638.maxBalancedShipments(weight));
    }

    @Test
    public void example2() {
        int[] weight = {4, 4};
        int expected = 0;
        Assertions.assertEquals(expected, solution3638.maxBalancedShipments(weight));
    }
}