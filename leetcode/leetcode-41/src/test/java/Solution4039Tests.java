import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4039Tests {
    private final Solution4039 solution4039 = new Solution4039();

    @Test
    public void example1() {
        long[] nums = {231};
        int expected = 8;
        Assertions.assertEquals(expected, solution4039.sumDecoded(nums));
    }

    @Test
    public void example2() {
        long[] nums = {2522, 2101};
        int expected = 1649;
        Assertions.assertEquals(expected, solution4039.sumDecoded(nums));
    }

    @Test
    public void example3() {
        long[] nums = {2301};
        int expected = 73741817;
        Assertions.assertEquals(expected, solution4039.sumDecoded(nums));
    }
}