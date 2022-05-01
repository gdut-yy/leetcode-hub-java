import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6051Tests {
    private final Solution6051 solution6051 = new Solution6051();

    @Test
    public void example1() {
        String[] words = {"a", "b", "c", "ab", "bc", "abc"};
        String s = "abc";
        int expected = 3;
        Assertions.assertEquals(expected, solution6051.countPrefixes(words, s));
    }

    @Test
    public void example2() {
        String[] words = {"a", "a"};
        String s = "aa";
        int expected = 2;
        Assertions.assertEquals(expected, solution6051.countPrefixes(words, s));
    }
}
