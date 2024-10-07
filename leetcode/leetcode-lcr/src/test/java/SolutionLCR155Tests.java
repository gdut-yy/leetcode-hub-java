import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR155Tests {
    private final SolutionLCR155 solutionLCR155 = new SolutionLCR155();

    @Test
    public void example1() {
        SolutionLCR155.Node root = new SolutionLCR155.Node(4);
        root.left = new SolutionLCR155.Node(2);
        root.right = new SolutionLCR155.Node(5);
        root.left.left = new SolutionLCR155.Node(1);
        root.left.right = new SolutionLCR155.Node(3);
        // expected
        SolutionLCR155.Node expected = new SolutionLCR155.Node(1);
        expected.right = new SolutionLCR155.Node(2);
        expected.right.right = new SolutionLCR155.Node(3);
        expected.right.right.right = new SolutionLCR155.Node(4);
        expected.right.right.right.right = new SolutionLCR155.Node(5);
        expected.right.right.right.right.right = expected;
        expected.left = expected.right.right.right.right;
        expected.left.left = expected.right.right.right;
        expected.left.left.left = expected.right.right;
        expected.left.left.left.left = expected.right;
        expected.left.left.left.left.left = expected;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionLCR155.treeToDoublyList(root)));
    }
}
