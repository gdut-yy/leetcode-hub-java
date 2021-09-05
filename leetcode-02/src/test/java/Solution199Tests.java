import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution199Tests {
    private final Solution199 solution199 = new Solution199();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        List<Integer> expected = List.of(1, 3, 4);
        Assertions.assertEquals(expected, solution199.rightSideView(root));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        List<Integer> expected = List.of(1, 3);
        Assertions.assertEquals(expected, solution199.rightSideView(root));
    }

    @Test
    public void example3() {
        TreeNode root = null;
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution199.rightSideView(root));
    }
}
