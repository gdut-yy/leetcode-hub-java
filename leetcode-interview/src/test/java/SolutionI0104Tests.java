import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0104Tests {
    private final SolutionI0104 solutionI0104 = new SolutionI0104();

    @Test
    public void example1() {
        String s = "tactcoa";
        Assertions.assertTrue(solutionI0104.canPermutePalindrome(s));
    }
}
