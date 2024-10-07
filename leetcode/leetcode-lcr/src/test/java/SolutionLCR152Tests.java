import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR152Tests {
    private final SolutionLCR152 solutionLCR152 = new SolutionLCR152();

    @Test
    public void example1() {
        int[] postorder = {1, 6, 3, 2, 5};
        Assertions.assertFalse(solutionLCR152.verifyTreeOrder(postorder));
    }

    @Test
    public void example2() {
        int[] postorder = {1, 3, 2, 6, 5};
        Assertions.assertTrue(solutionLCR152.verifyTreeOrder(postorder));
    }
}
