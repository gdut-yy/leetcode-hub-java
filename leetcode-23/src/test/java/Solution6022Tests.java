import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6022Tests {
    private final Solution6022 solution6022 = new Solution6022();

    @Test
    public void example1() {
        int[] nums = {5, 19, 8, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution6022.halveArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 8, 20};
        int expected = 3;
        Assertions.assertEquals(expected, solution6022.halveArray(nums));
    }
}
