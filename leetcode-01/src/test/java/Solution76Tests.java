import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution76Tests {
    private final Solution76 solution76 = new Solution76();

    @Test
    public void example1() {
        String s = "ADOBECODEBANC", t = "ABC";
        String expected = "BANC";
        Assertions.assertEquals(expected, solution76.minWindow(s, t));
    }

    @Test
    public void example2() {
        String s = "a", t = "a";
        String expected = "a";
        Assertions.assertEquals(expected, solution76.minWindow(s, t));
    }

    // --- 以下为解答错误的补充用例

    @Test
    public void example3() {
        String s = "aa", t = "a";
        String expected = "a";
        Assertions.assertEquals(expected, solution76.minWindow(s, t));
    }

    @Test
    public void example4() {
        String s = "a", t = "b";
        String expected = "";
        Assertions.assertEquals(expected, solution76.minWindow(s, t));
    }

    @Test
    public void example5() {
        String s = "a", t = "aa";
        String expected = "";
        Assertions.assertEquals(expected, solution76.minWindow(s, t));
    }

    @Test
    public void example6() {
        String s = "aa", t = "aa";
        String expected = "aa";
        Assertions.assertEquals(expected, solution76.minWindow(s, t));
    }

    @Test
    public void example7() {
        String s = "acbbaca", t = "aba";
        String expected = "baca";
        Assertions.assertEquals(expected, solution76.minWindow(s, t));
    }

    @Test
    public void example8() {
        String s = "cabwefgewcwaefgcf", t = "cae";
        String expected = "cwae";
        Assertions.assertEquals(expected, solution76.minWindow(s, t));
    }
}
