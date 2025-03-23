import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3483Tests {
    private final Solution3483 solution3483 = new Solution3483();

    @Test
    public void example1() {
        int[] digits = {1, 2, 3, 4};
        int expected = 12;
        Assertions.assertEquals(expected, solution3483.totalNumbers(digits));
    }

    @Test
    public void example2() {
        int[] digits = {0, 2, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution3483.totalNumbers(digits));
    }

    @Test
    public void example3() {
        int[] digits = {6, 6, 6};
        int expected = 1;
        Assertions.assertEquals(expected, solution3483.totalNumbers(digits));
    }

    @Test
    public void example4() {
        int[] digits = {1, 3, 5};
        int expected = 0;
        Assertions.assertEquals(expected, solution3483.totalNumbers(digits));
    }
}