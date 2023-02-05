import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6331Tests {
    private final Solution6331 solution6331 = new Solution6331();

    @Test
    public void example1() {
        int[] prizePositions = {1, 1, 2, 2, 3, 3, 5};
        int k = 2;
        int expected = 7;
        Assertions.assertEquals(expected, solution6331.maximizeWin(prizePositions, k));
    }

    @Test
    public void example2() {
        int[] prizePositions = {1, 2, 3, 4};
        int k = 0;
        int expected = 2;
        Assertions.assertEquals(expected, solution6331.maximizeWin(prizePositions, k));
    }
}