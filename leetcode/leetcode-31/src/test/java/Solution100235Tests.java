import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100235Tests {
    private final Solution100235 solution100235 = new Solution100235();

    @Test
    public void example1() {
        int numBottles = 13;
        int numExchange = 6;
        int expected = 15;
        Assertions.assertEquals(expected, solution100235.maxBottlesDrunk(numBottles, numExchange));
    }

    @Test
    public void example2() {
        int numBottles = 10;
        int numExchange = 3;
        int expected = 13;
        Assertions.assertEquals(expected, solution100235.maxBottlesDrunk(numBottles, numExchange));
    }
}