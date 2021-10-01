import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0102Tests {
    private final SolutionI0102 solutionI0102 = new SolutionI0102();

    @Test
    public void example1() {
        String s1 = "abc";
        String s2 = "bca";
        Assertions.assertTrue(solutionI0102.CheckPermutation(s1, s2));
    }

    @Test
    public void example2() {
        String s1 = "abc";
        String s2 = "bad";
        Assertions.assertFalse(solutionI0102.CheckPermutation(s1, s2));
    }
}
