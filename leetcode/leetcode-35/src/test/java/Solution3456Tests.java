import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3456Tests {
    private final Solution3456 solution3456 = new Solution3456();

    @Test
    public void example1() {
        String s = "aaabaaa";
        int k = 3;
        Assertions.assertTrue(solution3456.hasSpecialSubstring(s, k));
    }

    @Test
    public void example2() {
        String s = "abc";
        int k = 2;
        Assertions.assertFalse(solution3456.hasSpecialSubstring(s, k));
    }
}