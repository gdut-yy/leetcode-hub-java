import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3629Tests {
    private final Solution3629 solution3629 = new Solution3629();

    @Test
    public void example1() {
        int[] nums = {1, 2, 4, 6};
        int expected = 2;
        Assertions.assertEquals(expected, solution3629.minJumps(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 4, 7, 9};
        int expected = 2;
        Assertions.assertEquals(expected, solution3629.minJumps(nums));
    }

    @Test
    public void example3() {
        int[] nums = {4, 6, 5, 8};
        int expected = 3;
        Assertions.assertEquals(expected, solution3629.minJumps(nums));
    }
}