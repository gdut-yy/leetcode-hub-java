import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3894Tests {
    private final Solution3894 solution3894 = new Solution3894();

    @Test
    public void example1() {
        int timer = 60;
        String expected = "Red";
        Assertions.assertEquals(expected, solution3894.trafficSignal(timer));
    }

    @Test
    public void example2() {
        int timer = 5;
        String expected = "Invalid";
        Assertions.assertEquals(expected, solution3894.trafficSignal(timer));
    }
}