import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0406Tests {
    private final SolutionI0406 solutionI0406 = new SolutionI0406();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[2,1,3]");
        TreeNode p = new TreeNode(1);
        TreeNode expected = root;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionI0406.inorderSuccessor(root, p)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[5,3,6,2,4,null,null,1]");
        TreeNode p = new TreeNode(6);
        TreeNode expected = null;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionI0406.inorderSuccessor(root, p)));
    }
}
