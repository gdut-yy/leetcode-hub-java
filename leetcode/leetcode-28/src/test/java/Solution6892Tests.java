import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6892Tests {
    private final Solution6892 solution6892 = new Solution6892();

    @Test
    public void example1() {
        String[] words = {"cd", "ac", "dc", "ca", "zz"};
        int expected = 2;
        Assertions.assertEquals(expected, solution6892.maximumNumberOfStringPairs(words));
    }

    @Test
    public void example2() {
        String[] words = {"ab", "ba", "cc"};
        int expected = 1;
        Assertions.assertEquals(expected, solution6892.maximumNumberOfStringPairs(words));
    }

    @Test
    public void example3() {
        String[] words = {"aa", "ab"};
        int expected = 0;
        Assertions.assertEquals(expected, solution6892.maximumNumberOfStringPairs(words));
    }
}