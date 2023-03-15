import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO33Tests {
    private final SolutionO33 solutionO33 = new SolutionO33();

    @Test
    public void example1() {
        int[] postorder = {1, 6, 3, 2, 5};
        Assertions.assertFalse(solutionO33.verifyPostorder(postorder));
    }

    @Test
    public void example2() {
        int[] postorder = {1, 3, 2, 6, 5};
        Assertions.assertTrue(solutionO33.verifyPostorder(postorder));
    }
}
