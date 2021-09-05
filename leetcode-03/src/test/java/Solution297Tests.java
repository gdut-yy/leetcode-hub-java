import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution297Tests {
    private final Solution297.Codec codec = new Solution297.Codec();

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

    @Test
    public void example2() {
        TreeNode root = null;
        String serializeStr = codec.serialize(root);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(root, codec.deserialize(serializeStr)));
    }

    @Test
    public void example3() {
        TreeNode root = new TreeNode(1);
        String serializeStr = codec.serialize(root);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(root, codec.deserialize(serializeStr)));
    }

    @Test
    public void example4() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        String serializeStr = codec.serialize(root);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(root, codec.deserialize(serializeStr)));
    }
}
