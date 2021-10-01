import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0106Tests {
    private final SolutionI0106 solutionI0106 = new SolutionI0106();

    @Test
    public void example1() {
        String S = "aabcccccaaa";
        String expected = "a2b1c5a3";
        Assertions.assertEquals(expected, solutionI0106.compressString(S));
    }

    @Test
    public void example2() {
        String S = "abbccd";
        String expected = "abbccd";
        Assertions.assertEquals(expected, solutionI0106.compressString(S));
    }

    // 补充用例
    @Test
    public void example3() {
        String S = "";
        String expected = "";
        Assertions.assertEquals(expected, solutionI0106.compressString(S));
    }

    @Test
    public void example4() {
        String S = "bb";
        String expected = "bb";
        Assertions.assertEquals(expected, solutionI0106.compressString(S));
    }
}
