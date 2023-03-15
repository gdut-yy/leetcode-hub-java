import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Hhrc220925T3Tests {
    private final Hhrc220925T3 hhrc220925T3 = new Hhrc220925T3();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,3,3,null,2,null,2]");
        List<TreeNode> expected = List.of(TreeNode.buildTreeNode("[3,null,2]"), TreeNode.buildTreeNode("[2]"));
//        Assertions.assertEquals(expected, hhrc220925T3.lightDistribution(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[3,3,2,null,2]");
        List<TreeNode> expected = List.of(TreeNode.buildTreeNode("[2]"));
//        Assertions.assertEquals(expected, hhrc220925T3.lightDistribution(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,3,3,null,2,2]");
        List<TreeNode> expected = List.of(TreeNode.buildTreeNode("[2]"));
//        Assertions.assertEquals(expected, hhrc220925T3.lightDistribution(root));
    }
}
