import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO36Tests {
    private final SolutionO36 solutionO36 = new SolutionO36();

    @Test
    public void example1() {
        SolutionO36.Node root = new SolutionO36.Node(4);
        root.left = new SolutionO36.Node(2);
        root.right = new SolutionO36.Node(5);
        root.left.left = new SolutionO36.Node(1);
        root.left.right = new SolutionO36.Node(3);
        // expected
        SolutionO36.Node expected = new SolutionO36.Node(1);
        expected.right = new SolutionO36.Node(2);
        expected.right.right = new SolutionO36.Node(3);
        expected.right.right.right = new SolutionO36.Node(4);
        expected.right.right.right.right = new SolutionO36.Node(5);
        expected.right.right.right.right.right = expected;
        expected.left = expected.right.right.right.right;
        expected.left.left = expected.right.right.right;
        expected.left.left.left = expected.right.right;
        expected.left.left.left.left = expected.right;
        expected.left.left.left.left.left = expected;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solutionO36.treeToDoublyList(root)));
    }
}
