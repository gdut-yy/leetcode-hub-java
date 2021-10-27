import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO19Tests {
    private final SolutionO19 solutionO19 = new SolutionO19();

    @Test
    public void example1() {
        String s = "aa";
        String p = "a";
        Assertions.assertFalse(solutionO19.isMatch(s, p));
    }

    @Test
    public void example2() {
        String s = "aa";
        String p = "a*";
        Assertions.assertTrue(solutionO19.isMatch(s, p));
    }

    @Test
    public void example3() {
        String s = "ab";
        String p = ".*";
        Assertions.assertTrue(solutionO19.isMatch(s, p));
    }

    @Test
    public void example4() {
        String s = "aab";
        String p = "c*a*b";
        Assertions.assertTrue(solutionO19.isMatch(s, p));
    }

    @Test
    public void example5() {
        String s = "mississippi";
        String p = "mis*is*p*.";
        Assertions.assertFalse(solutionO19.isMatch(s, p));
    }
}
