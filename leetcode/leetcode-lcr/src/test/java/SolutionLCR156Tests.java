import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR156Tests {
    private final SolutionLCR156.Codec codec = new SolutionLCR156.Codec();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,null,null,4,5]");
        String serializeStr = codec.serialize(root);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(root, codec.deserialize(serializeStr)));
    }
}
