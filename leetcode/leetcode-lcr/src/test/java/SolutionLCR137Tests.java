import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR137Tests {
    private final SolutionLCR137 solutionLCR137 = new SolutionLCR137();

    @Test
    public void example1() {
        String s = "aa";
        String p = "a";
        Assertions.assertFalse(solutionLCR137.articleMatch(s, p));
    }

    @Test
    public void example2() {
        String s = "aa";
        String p = "a*";
        Assertions.assertTrue(solutionLCR137.articleMatch(s, p));
    }

    @Test
    public void example3() {
        String s = "ab";
        String p = ".*";
        Assertions.assertTrue(solutionLCR137.articleMatch(s, p));
    }

    @Test
    public void example4() {
        String s = "aab";
        String p = "c*a*b";
        Assertions.assertTrue(solutionLCR137.articleMatch(s, p));
    }

    @Test
    public void example5() {
        String s = "mississippi";
        String p = "mis*is*p*.";
        Assertions.assertFalse(solutionLCR137.articleMatch(s, p));
    }
}
