import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1650Tests {
    private final Solution1650 solution1650 = new Solution1650();

    @Test
    public void example1() {
        Solution1650.Node root = new Solution1650.Node(3);
        root.left = new Solution1650.Node(5);
        root.right = new Solution1650.Node(1);
        root.left.parent = root;
        root.right.parent = root;
        root.left.left = new Solution1650.Node(6);
        root.left.right = new Solution1650.Node(2);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;
        root.right.left = new Solution1650.Node(0);
        root.right.right = new Solution1650.Node(8);
        root.right.left.parent = root.right;
        root.right.right.parent = root.right;
        root.left.right.left = new Solution1650.Node(7);
        root.left.right.right = new Solution1650.Node(4);
        root.left.right.left.parent = root.left.right;
        root.left.right.right.parent = root.left.right;

        Solution1650.Node p = root.left;
        Solution1650.Node q = root.right;
        Solution1650.Node expected = root;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution1650.lowestCommonAncestor(p, q)));
    }

    @Test
    public void example2() {
        Solution1650.Node root = new Solution1650.Node(3);
        root.left = new Solution1650.Node(5);
        root.right = new Solution1650.Node(1);
        root.left.parent = root;
        root.right.parent = root;
        root.left.left = new Solution1650.Node(6);
        root.left.right = new Solution1650.Node(2);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;
        root.right.left = new Solution1650.Node(0);
        root.right.right = new Solution1650.Node(8);
        root.right.left.parent = root.right;
        root.right.right.parent = root.right;
        root.left.right.left = new Solution1650.Node(7);
        root.left.right.right = new Solution1650.Node(4);
        root.left.right.left.parent = root.left.right;
        root.left.right.right.parent = root.left.right;

        Solution1650.Node p = root.left;
        Solution1650.Node q = root.left.right.right;
        Solution1650.Node expected = root.left;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution1650.lowestCommonAncestor(p, q)));
    }

    @Test
    public void example3() {
        Solution1650.Node root = new Solution1650.Node(1);
        root.left = new Solution1650.Node(2);
        root.left.parent = root;

        Solution1650.Node p = root;
        Solution1650.Node q = root.left;
        Solution1650.Node expected = root;
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution1650.lowestCommonAncestor(p, q)));
    }
}
