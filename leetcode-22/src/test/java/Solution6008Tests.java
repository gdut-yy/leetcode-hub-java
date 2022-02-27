import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6008Tests {
    private final Solution6008 solution6008 = new Solution6008();

    @Test
    public void example1() {
        String[] words = {"pay", "attention", "practice", "attend"};
        String pref = "at";
        int expected = 2;
        Assertions.assertEquals(expected, solution6008.prefixCount(words, pref));
    }

    @Test
    public void example2() {
        String[] words = {"leetcode", "win", "loops", "success"};
        String pref = "code";
        int expected = 0;
        Assertions.assertEquals(expected, solution6008.prefixCount(words, pref));
    }
}
