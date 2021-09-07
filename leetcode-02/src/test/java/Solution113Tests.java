import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution113Tests {
    private final Solution113 solution113 = new Solution113();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;
        List<List<Integer>> expected = List.of(List.of(5, 4, 11, 2), List.of(5, 8, 4, 5));
        Assertions.assertEquals(expected, solution113.pathSum(root, targetSum));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int targetSum = 5;
        List<List<Integer>> expected = new ArrayList<>();
        Assertions.assertEquals(expected, solution113.pathSum(root, targetSum));
    }

    @Test
    public void example3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int targetSum = 0;
        List<List<Integer>> expected = new ArrayList<>();
        Assertions.assertEquals(expected, solution113.pathSum(root, targetSum));
    }
}
