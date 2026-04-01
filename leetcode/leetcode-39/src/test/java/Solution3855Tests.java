import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3855Tests {
    private final Solution3855 solution3855 = new Solution3855();

    @Test
    public void example1() {
        int l = 1;
        int r = 2;
        int k = 2;
        int expected = 66;
        Assertions.assertEquals(expected, solution3855.sumOfNumbers(l, r, k));
    }

    @Test
    public void example2() {
        int l = 0;
        int r = 1;
        int k = 3;
        int expected = 444;
        Assertions.assertEquals(expected, solution3855.sumOfNumbers(l, r, k));
    }

    @Test
    public void example3() {
        int l = 5;
        int r = 5;
        int k = 10;
        int expected = 555555520;
        Assertions.assertEquals(expected, solution3855.sumOfNumbers(l, r, k));
    }
}