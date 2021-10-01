import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0101Tests {
    private final SolutionI0101 solutionI0101 = new SolutionI0101();

    @Test
    public void example1() {
        String astr = "leetcode";
        Assertions.assertFalse(solutionI0101.isUnique(astr));
    }

    @Test
    public void example2() {
        String astr = "abc";
        Assertions.assertTrue(solutionI0101.isUnique(astr));
    }
}
