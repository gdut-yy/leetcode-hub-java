import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3458Tests {
    private final Solution3458 solution3458 = new Solution3458();

    @Test
    public void example1() {
        String s = "abcdbaefab";
        int k = 2;
        Assertions.assertTrue(solution3458.maxSubstringLength(s, k));
    }

    @Test
    public void example2() {
        String s = "cdefdc";
        int k = 3;
        Assertions.assertFalse(solution3458.maxSubstringLength(s, k));
    }

    @Test
    public void example3() {
        String s = "abeabe";
        int k = 0;
        Assertions.assertTrue(solution3458.maxSubstringLength(s, k));
    }
}