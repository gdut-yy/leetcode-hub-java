import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6172Tests {
    private final Solution6172 solution6172 = new Solution6172();

    @Test
    public void example1() {
        int n = 9;
        Assertions.assertFalse(solution6172.isStrictlyPalindromic(n));
        Assertions.assertFalse(solution6172.isStrictlyPalindromic2(n));
    }

    @Test
    public void example2() {
        int n = 4;
        Assertions.assertFalse(solution6172.isStrictlyPalindromic(n));
        Assertions.assertFalse(solution6172.isStrictlyPalindromic2(n));
    }
}
