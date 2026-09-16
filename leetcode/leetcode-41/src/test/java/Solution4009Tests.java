import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4009Tests {
    private final Solution4009 solution4009 = new Solution4009();

    @Test
    public void example1() {
        int[] demand = {6, 8, 4, 6, 5};
        int[] fuel = {16, 13};
        int expected = 6;
        Assertions.assertEquals(expected, solution4009.minMaxWaitingTime(demand, fuel));
    }

    @Test
    public void example2() {
        int[] demand = {10, 15};
        int[] fuel = {12, 17};
        int expected = 0;
        Assertions.assertEquals(expected, solution4009.minMaxWaitingTime(demand, fuel));
    }

    @Test
    public void example3() {
        int[] demand = {10, 5};
        int[] fuel = {8, 8};
        int expected = -1;
        Assertions.assertEquals(expected, solution4009.minMaxWaitingTime(demand, fuel));
    }
}