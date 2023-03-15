import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Solution431Tests {
    @Test
    public void example1() {
        Solution431.Node root = new Solution431.Node(1, new ArrayList<>());
        root.children.add(new Solution431.Node(3, new ArrayList<>()));
        root.children.add(new Solution431.Node(2, new ArrayList<>()));
        root.children.add(new Solution431.Node(4, new ArrayList<>()));
        root.children.get(0).children.add(new Solution431.Node(5, new ArrayList<>()));
        root.children.get(0).children.add(new Solution431.Node(6, new ArrayList<>()));

        Solution431.Codec codec = new Solution431.Codec();
        Assertions.assertTrue(UtUtils.assertJsonEquals(root, codec.decode(codec.encode(root))));
    }
}
