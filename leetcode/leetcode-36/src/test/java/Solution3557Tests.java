import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3557Tests {
    private final Solution3557 solution3557 = new Solution3557();

    @Test
    public void example1() {
        String word = "abcdeafdef";
        int expected = 2;
        Assertions.assertEquals(expected, solution3557.maxSubstrings(word));
    }

    @Test
    public void example2() {
        String word = "bcdaaaab";
        int expected = 1;
        Assertions.assertEquals(expected, solution3557.maxSubstrings(word));
    }
}