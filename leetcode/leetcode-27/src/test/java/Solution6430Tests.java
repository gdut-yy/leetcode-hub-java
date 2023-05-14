import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6430Tests {
    private final Solution6430 solution6430 = new Solution6430();

    @Test
    public void example1() {
        int n = 5;
        int k = 2;
        int[] expected = {4, 5};
        Assertions.assertArrayEquals(expected, solution6430.circularGameLosers(n, k));
    }

    @Test
    public void example2() {
        int n = 4;
        int k = 4;
        int[] expected = {2, 3, 4};
        Assertions.assertArrayEquals(expected, solution6430.circularGameLosers(n, k));
    }
}