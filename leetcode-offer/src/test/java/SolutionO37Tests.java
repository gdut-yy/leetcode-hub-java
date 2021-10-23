import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO37Tests {
    private final SolutionO37.Codec codec = new SolutionO37.Codec();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serializeStr = codec.serialize(root);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(root, codec.deserialize(serializeStr)));
    }
}
