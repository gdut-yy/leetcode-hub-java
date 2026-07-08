import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3952Tests {
    private final Solution3952 solution3952 = new Solution3952();

    @Test
    public void example1() {
        int[] nums = {9, 2, 6, 1};
        String s = "0101";
        long expected = 15;
        Assertions.assertEquals(expected, solution3952.maxTotal(nums, s));
    }

    @Test
    public void example2() {
        int[] nums = {5,1,4};
        String s = "001";
        long expected = 4;
        Assertions.assertEquals(expected, solution3952.maxTotal(nums, s));
    }

    @Test
    public void example3() {
        int[] nums = {9,3,5};
        String s = "011";
        long expected = 14;
        Assertions.assertEquals(expected, solution3952.maxTotal(nums, s));
    }
}