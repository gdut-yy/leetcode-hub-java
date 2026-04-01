import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3883Tests {
    private final Solution3883 solution3883 = new Solution3883();

    @Test
    public void example1() {
        int[] digitSum = {25, 1};
        int expected = 6;
        Assertions.assertEquals(expected, solution3883.countArrays(digitSum));
    }

    @Test
    public void example2() {
        int[] digitSum = {1};
        int expected = 4;
        Assertions.assertEquals(expected, solution3883.countArrays(digitSum));
    }

    @Test
    public void example3() {
        int[] digitSum = {2, 49, 23};
        int expected = 0;
        Assertions.assertEquals(expected, solution3883.countArrays(digitSum));
    }
}