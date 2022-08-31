import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution652Tests {
    private final Solution652 solution652 = new Solution652();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,null,2,4,null,null,4]");
        List<TreeNode> expected = List.of(TreeNode.buildTreeNode("[2,4]"), TreeNode.buildTreeNode("[4]"));
//        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution652.findDuplicateSubtrees(root)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[2,2,2,3,null,3,null]");
        List<TreeNode> expected = List.of(TreeNode.buildTreeNode("[2,3]"), TreeNode.buildTreeNode("[3]"));
//        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, solution652.findDuplicateSubtrees(root)));
    }
}
