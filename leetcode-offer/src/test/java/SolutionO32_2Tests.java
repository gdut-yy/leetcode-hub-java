import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionO32_2Tests {
    private final SolutionO32_2 solutionO32_2 = new SolutionO32_2();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> expected = List.of(List.of(3), List.of(9, 20), List.of(15, 7));
        Assertions.assertEquals(expected, solutionO32_2.levelOrder(root));
    }
}
