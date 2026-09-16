import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4030Tests {
    private final Solution4030 solution4030 = new Solution4030();

    @Test
    public void example1() {
        String s = "ff";
        Assertions.assertTrue(solution4030.isPalindromic(s));
    }

    @Test
    public void example2() {
        String s = "leet";
        Assertions.assertFalse(solution4030.isPalindromic(s));
    }
}