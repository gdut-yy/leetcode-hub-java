import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100222Tests {
    private final Solution100222 solution100222 = new Solution100222();

    @Test
    public void example1() {
        int[] nums = {3, 3, 3};
        String expected = "equilateral";
        Assertions.assertEquals(expected, solution100222.triangleType(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 4, 5};
        String expected = "scalene";
        Assertions.assertEquals(expected, solution100222.triangleType(nums));
    }
}