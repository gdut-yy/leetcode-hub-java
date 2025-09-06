import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3460Tests {
    private final SolutionP3460 solutionP3460 = new SolutionP3460();

    @Test
    public void example1() {
        String s = "madxa";
        String t = "madam";
        int expected = 4;
        Assertions.assertEquals(expected, solutionP3460.longestCommonPrefix(s, t));
    }

    @Test
    public void example2() {
        String s = "leetcode";
        String t = "eetcode";
        int expected = 7;
        Assertions.assertEquals(expected, solutionP3460.longestCommonPrefix(s, t));
    }

    @Test
    public void example3() {
        String s = "one";
        String t = "one";
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3460.longestCommonPrefix(s, t));
    }

    @Test
    public void example4() {
        String s = "a";
        String t = "b";
        int expected = 0;
        Assertions.assertEquals(expected, solutionP3460.longestCommonPrefix(s, t));
    }
}