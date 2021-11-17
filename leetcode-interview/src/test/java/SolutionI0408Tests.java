import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0408Tests {
    private final SolutionI0408 solutionI0408 = new SolutionI0408();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode expected = root;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionI0408.lowestCommonAncestor(root, p, q)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        TreeNode expected = root.left;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionI0408.lowestCommonAncestor(root, p, q)));
    }
}
