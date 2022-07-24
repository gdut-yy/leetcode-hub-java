import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6131Tests {
    private final Solution6131 solution6131 = new Solution6131();

    @Test
    public void example1() {
        int[] rolls = {4, 2, 1, 2, 3, 3, 2, 4, 1};
        int k = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution6131.shortestSequence(rolls, k));
    }

    @Test
    public void example2() {
        int[] rolls = {1, 1, 2, 2};
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution6131.shortestSequence(rolls, k));
    }

    @Test
    public void example3() {
        int[] rolls = {1, 1, 3, 2, 2, 2, 3, 3};
        int k = 4;
        int expected = 1;
        Assertions.assertEquals(expected, solution6131.shortestSequence(rolls, k));
    }
}
