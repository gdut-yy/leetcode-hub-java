import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Hhrc220925T4Tests {
    private final Hhrc220925T4 hhrc220925T4 = new Hhrc220925T4();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[0,0,0]");
        int expected = 1;
        Assertions.assertEquals(expected, hhrc220925T4.minSupplyStationNumber(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[0,0,0,null,null,null,0]");
        int expected = 2;
        Assertions.assertEquals(expected, hhrc220925T4.minSupplyStationNumber(root));
    }
}
