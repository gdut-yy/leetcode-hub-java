import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1933Tests {
    private final Solution1933 solution1933 = new Solution1933();

    @Test
    public void example1() {
        String s = "000111000";
        Assertions.assertFalse(solution1933.isDecomposable(s));
    }

    @Test
    public void example2() {
        String s = "00011111222";
        Assertions.assertTrue(solution1933.isDecomposable(s));
    }

    @Test
    public void example3() {
        String s = "01110002223300";
        Assertions.assertFalse(solution1933.isDecomposable(s));
    }
}