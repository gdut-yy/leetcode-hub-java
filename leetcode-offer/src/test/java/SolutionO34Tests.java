import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionO34Tests {
    private final SolutionO34 solutionO34 = new SolutionO34();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        int targetSum = 22;
        List<List<Integer>> expected = List.of(List.of(5, 4, 11, 2), List.of(5, 8, 4, 5));
        Assertions.assertEquals(expected, solutionO34.pathSum(root, targetSum));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3]");
        int targetSum = 5;
        List<List<Integer>> expected = new ArrayList<>();
        Assertions.assertEquals(expected, solutionO34.pathSum(root, targetSum));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,2]");
        int targetSum = 0;
        List<List<Integer>> expected = new ArrayList<>();
        Assertions.assertEquals(expected, solutionO34.pathSum(root, targetSum));
    }
}
