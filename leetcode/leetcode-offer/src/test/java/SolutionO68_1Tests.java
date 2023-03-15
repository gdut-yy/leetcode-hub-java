import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO68_1Tests {
    private final SolutionO68_1 solutionO68_1 = new SolutionO68_1();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[6,2,8,0,4,7,9,null,null,3,5]");
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        TreeNode expected = root;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionO68_1.lowestCommonAncestor(root, p, q)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[6,2,8,0,4,7,9,null,null,3,5]");
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        TreeNode expected = root.left;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionO68_1.lowestCommonAncestor(root, p, q)));
    }
}
