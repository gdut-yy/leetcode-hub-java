import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1745Tests {
    private final Solution1745 solution1745 = new Solution1745();

    @Test
    public void example1() {
        String s = "abcbdd";
        Assertions.assertTrue(solution1745.checkPartitioning(s));
    }

    @Test
    public void example2() {
        String s = "bcbddxy";
        Assertions.assertFalse(solution1745.checkPartitioning(s));
    }
}