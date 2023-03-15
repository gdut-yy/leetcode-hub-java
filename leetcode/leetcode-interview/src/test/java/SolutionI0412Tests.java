import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0412Tests {
    private final SolutionI0412 solutionI0412 = new SolutionI0412();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        int targetSum = 22;
        int expected = 3;
        Assertions.assertEquals(expected, solutionI0412.pathSum(root, targetSum));
    }
}
