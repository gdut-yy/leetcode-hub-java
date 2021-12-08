import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1134Tests {
    private final Solution1134 solution1134 = new Solution1134();

    @Test
    public void example1() {
        int n = 153;
        Assertions.assertTrue(solution1134.isArmstrong(n));
    }

    @Test
    public void example2() {
        int n = 123;
        Assertions.assertFalse(solution1134.isArmstrong(n));
    }
}
