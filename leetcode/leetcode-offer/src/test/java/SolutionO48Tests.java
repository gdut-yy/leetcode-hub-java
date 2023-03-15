import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO48Tests {
    private final SolutionO48 solutionO48 = new SolutionO48();

    @Test
    public void example1() {
        String s = "abcabcbb";
        int expected = 3;
        Assertions.assertEquals(expected, solutionO48.lengthOfLongestSubstring(s));
    }

    @Test
    public void example2() {
        String s = "bbbbb";
        int expected = 1;
        Assertions.assertEquals(expected, solutionO48.lengthOfLongestSubstring(s));
    }

    @Test
    public void example3() {
        String s = "pwwkew";
        int expected = 3;
        Assertions.assertEquals(expected, solutionO48.lengthOfLongestSubstring(s));
    }
}
