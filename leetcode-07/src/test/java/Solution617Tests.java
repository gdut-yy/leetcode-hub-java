import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution617Tests {
    private final Solution617 solution617 = new Solution617();

    @Test
    public void example1() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        TreeNode expected = new TreeNode(3);
        expected.left = new TreeNode(4);
        expected.right = new TreeNode(5);
        expected.left.left = new TreeNode(5);
        expected.left.right = new TreeNode(4);
        expected.right.right = new TreeNode(7);

        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution617.mergeTrees(root1, root2)));
    }
}
