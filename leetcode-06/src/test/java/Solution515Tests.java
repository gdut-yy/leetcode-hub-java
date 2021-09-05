import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution515Tests {
    private final Solution515 solution515 = new Solution515();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        List<Integer> expected = List.of(1, 3, 9);
        Assertions.assertEquals(expected, solution515.largestValues(root));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Integer> expected = List.of(1, 3);
        Assertions.assertEquals(expected, solution515.largestValues(root));
    }

    @Test
    public void example3() {
        TreeNode root = new TreeNode(1);
        List<Integer> expected = List.of(1);
        Assertions.assertEquals(expected, solution515.largestValues(root));
    }

    @Test
    public void example4() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        List<Integer> expected = List.of(1, 2);
        Assertions.assertEquals(expected, solution515.largestValues(root));
    }

    @Test
    public void example5() {
        TreeNode root = null;
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution515.largestValues(root));
    }
}
