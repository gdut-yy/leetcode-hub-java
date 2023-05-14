import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6431Tests {
    private final Solution6431 solution6431 = new Solution6431();

    @Test
    public void example1() {
        int[] derived = {1, 1, 0};
        Assertions.assertTrue(solution6431.doesValidArrayExist(derived));
    }

    @Test
    public void example2() {
        int[] derived = {1, 1};
        Assertions.assertTrue(solution6431.doesValidArrayExist(derived));
    }

    @Test
    public void example3() {
        int[] derived = {1, 0};
        Assertions.assertFalse(solution6431.doesValidArrayExist(derived));
    }
}