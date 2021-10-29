import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO37Tests {
    private final SolutionO37.Codec codec = new SolutionO37.Codec();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,null,null,4,5]");
        String serializeStr = codec.serialize(root);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(root, codec.deserialize(serializeStr)));
    }
}
