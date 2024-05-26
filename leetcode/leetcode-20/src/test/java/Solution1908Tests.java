import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1908Tests {
    private final Solution1908 solution1908 = new Solution1908();

    @Test
    public void example1() {
        int[] piles = {1};
        Assertions.assertTrue(solution1908.nimGame(piles));
    }

    @Test
    public void example2() {
        int[] piles = {1, 1};
        Assertions.assertFalse(solution1908.nimGame(piles));
    }

    @Test
    public void example3() {
        int[] piles = {1, 2, 3};
        Assertions.assertFalse(solution1908.nimGame(piles));
    }
}