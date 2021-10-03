import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution246Tests {
    private final Solution246 solution246 = new Solution246();

    @Test
    public void example1() {
        String num = "69";
        Assertions.assertTrue(solution246.isStrobogrammatic(num));
    }

    @Test
    public void example2() {
        String num = "88";
        Assertions.assertTrue(solution246.isStrobogrammatic(num));
    }

    @Test
    public void example3() {
        String num = "962";
        Assertions.assertFalse(solution246.isStrobogrammatic(num));
    }

    @Test
    public void example4() {
        String num = "1";
        Assertions.assertTrue(solution246.isStrobogrammatic(num));
    }
}
