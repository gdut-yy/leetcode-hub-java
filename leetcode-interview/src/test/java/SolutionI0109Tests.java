import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0109Tests {
    private final SolutionI0109 solutionI0109 = new SolutionI0109();

    @Test
    public void example1() {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        Assertions.assertTrue(solutionI0109.isFlipedString(s1, s2));
    }

    @Test
    public void example2() {
        String s1 = "aa";
        String s2 = "aba";
        Assertions.assertFalse(solutionI0109.isFlipedString(s1, s2));
    }
}
