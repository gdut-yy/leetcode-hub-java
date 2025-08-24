import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3646Tests {
    private final Solution3646.V1 solution3646_v1 = new Solution3646.V1();
    private final Solution3646.V2 solution3646_v2 = new Solution3646.V2();

    @Test
    public void example1() {
        long n = 2;
        long expected = 22;
        Assertions.assertEquals(expected, solution3646_v1.specialPalindrome(n));
        Assertions.assertEquals(expected, solution3646_v2.specialPalindrome(n));
    }

    @Test
    public void example2() {
        long n = 33;
        long expected = 212;
        Assertions.assertEquals(expected, solution3646_v1.specialPalindrome(n));
        Assertions.assertEquals(expected, solution3646_v2.specialPalindrome(n));
    }
}