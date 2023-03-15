import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution266Tests {
    private final Solution266 solution266 = new Solution266();

    @Test
    public void example1() {
        String s = "code";
        Assertions.assertFalse(solution266.canPermutePalindrome(s));
    }

    @Test
    public void example2() {
        String s = "aab";
        Assertions.assertTrue(solution266.canPermutePalindrome(s));
    }

    @Test
    public void example3() {
        String s = "carerac";
        Assertions.assertTrue(solution266.canPermutePalindrome(s));
    }
}
