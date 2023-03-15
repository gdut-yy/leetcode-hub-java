import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution428Tests {
    private final Solution428.Codec codec = new Solution428.Codec();

    @Test
    public void example1() {
        Solution428.Node root = codec.deserialize("[1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]");
        String serializeStr = codec.serialize(root);
        Assertions.assertTrue(UtUtils.assertJsonEquals(root, codec.deserialize(serializeStr)));
    }

    @Test
    public void example2() {
        Solution428.Node root = codec.deserialize("[1,null,3,2,4,null,5,6]");
        String serializeStr = codec.serialize(root);
        Assertions.assertTrue(UtUtils.assertJsonEquals(root, codec.deserialize(serializeStr)));
    }

    @Test
    public void example3() {
        Solution428.Node root = codec.deserialize("[]");
        String serializeStr = codec.serialize(root);
        Assertions.assertTrue(UtUtils.assertJsonEquals(root, codec.deserialize(serializeStr)));
    }
}
