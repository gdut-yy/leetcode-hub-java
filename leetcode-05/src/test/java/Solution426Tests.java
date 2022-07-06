import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution426Tests {
    private final Solution426 solution426 = new Solution426();

    @Test
    public void example1() {
        Solution426.Node root = new Solution426.Node(4);
        root.left = new Solution426.Node(2);
        root.right = new Solution426.Node(5);
        root.left.left = new Solution426.Node(1);
        root.left.right = new Solution426.Node(3);

        Solution426.Node expected = new Solution426.Node(1);
        expected.right = new Solution426.Node(2);
        expected.right.right = new Solution426.Node(3);
        expected.right.right.right = new Solution426.Node(4);
        expected.right.right.right.right = new Solution426.Node(5);
        expected.right.right.right.right.right = expected;

        expected.right.left = expected;
        expected.right.right.left = expected.right;
        expected.right.right.right.left = expected.right.right;
        expected.right.right.right.right.left = expected.right.right.right;
        expected.left = expected.right.right.right.right;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution426.treeToDoublyList(root)));
    }

    @Test
    public void example2() {
        Solution426.Node root = new Solution426.Node(2);
        root.left = new Solution426.Node(1);
        root.right = new Solution426.Node(3);

        Solution426.Node expected = new Solution426.Node(1);
        expected.right = new Solution426.Node(2);
        expected.right.right = new Solution426.Node(3);
        expected.right.right.right = expected;

        expected.right.left = expected;
        expected.right.right.left = expected.right;
        expected.left = expected.right.right;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution426.treeToDoublyList(root)));
    }

    @Test
    public void example3() {
        Solution426.Node root = null;
        Solution426.Node expected = null;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution426.treeToDoublyList(root)));
    }

    @Test
    public void example4() {
        Solution426.Node root = new Solution426.Node(1);
        Solution426.Node expected = new Solution426.Node(1);
        expected.left = expected;
        expected.right = expected;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution426.treeToDoublyList(root)));
    }
}
