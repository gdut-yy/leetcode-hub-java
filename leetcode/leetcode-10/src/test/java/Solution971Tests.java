import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution971Tests {
    private final Solution971 solution971 = new Solution971();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2]");
        int[] voyage = {2, 1};
        List<Integer> expected = List.of(-1);
        Assertions.assertEquals(expected, solution971.flipMatchVoyage(root, voyage));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3]");
        int[] voyage = {1, 3, 2};
        List<Integer> expected = List.of(1);
        Assertions.assertEquals(expected, solution971.flipMatchVoyage(root, voyage));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3]");
        int[] voyage = {1, 2, 3};
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution971.flipMatchVoyage(root, voyage));
    }
}