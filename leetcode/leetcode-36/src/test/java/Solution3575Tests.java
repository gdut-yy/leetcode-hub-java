import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3575Tests {
    private final Solution3575 solution3575 = new Solution3575();

    @Test
    public void example1() {
        int[] vals = {2, 3};
        int[] par = {-1, 0};
        int expected = 8;
        Assertions.assertEquals(expected, solution3575.goodSubtreeSum(vals, par));
    }

    @Test
    public void example2() {
        int[] vals = {1, 5, 2};
        int[] par = {-1, 0, 0};
        int expected = 15;
        Assertions.assertEquals(expected, solution3575.goodSubtreeSum(vals, par));
    }

    @Test
    public void example3() {
        int[] vals = {34, 1, 2};
        int[] par = {-1, 0, 1};
        int expected = 42;
        Assertions.assertEquals(expected, solution3575.goodSubtreeSum(vals, par));
    }

    @Test
    public void example4() {
        int[] vals = {3, 22, 5};
        int[] par = {-1, 0, 1};
        int expected = 18;
        Assertions.assertEquals(expected, solution3575.goodSubtreeSum(vals, par));
    }
}