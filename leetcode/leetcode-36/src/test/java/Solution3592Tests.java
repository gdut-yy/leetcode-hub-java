import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3592Tests {
    private final Solution3592 solution3592 = new Solution3592();

    @Test
    public void example1() {
        int[] numWays = {0, 1, 0, 2, 0, 3, 0, 4, 0, 5};
        List<Integer> expected = List.of(2, 4, 6);
        Assertions.assertEquals(expected, solution3592.findCoins(numWays));
    }

    @Test
    public void example2() {
        int[] numWays = {1, 2, 2, 3, 4};
        List<Integer> expected = List.of(1, 2, 5);
        Assertions.assertEquals(expected, solution3592.findCoins(numWays));
    }

    @Test
    public void example3() {
        int[] numWays = {1, 2, 3, 4, 15};
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution3592.findCoins(numWays));
    }
}