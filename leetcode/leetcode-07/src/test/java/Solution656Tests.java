import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution656Tests {
    private final Solution656 solution656 = new Solution656();

    @Test
    public void example1() {
        int[] coins = {1, 2, 4, -1, 2};
        int maxJump = 2;
        List<Integer> expected = List.of(1, 3, 5);
        Assertions.assertEquals(expected, solution656.cheapestJump(coins, maxJump));
    }

    @Test
    public void example2() {
        int[] coins = {1, 2, 4, -1, 2};
        int maxJump = 1;
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution656.cheapestJump(coins, maxJump));
    }
}