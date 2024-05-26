import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2005Tests {
    private final Solution2005 solution2005 = new Solution2005();

    @Test
    public void example1() {
        int n = 3;
        Assertions.assertTrue(solution2005.findGameWinner(n));
        Assertions.assertTrue(solution2005.findGameWinner2(n));
    }

    @Test
    public void example2() {
        int n = 1;
        Assertions.assertFalse(solution2005.findGameWinner(n));
        Assertions.assertFalse(solution2005.findGameWinner2(n));
    }

    @Test
    public void example3() {
        int n = 2;
        Assertions.assertTrue(solution2005.findGameWinner(n));
        Assertions.assertTrue(solution2005.findGameWinner2(n));
    }
}