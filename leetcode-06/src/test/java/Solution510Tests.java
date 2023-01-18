import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution510Tests {
    private final Solution510 solution510 = new Solution510();

    @Test
    public void example1() {
        Solution510.Node node = new Solution510.Node(2);
        node.left = new Solution510.Node(1, node);
        node.right = new Solution510.Node(3, node);
        Solution510.Node expected = node.right;
        Assertions.assertEquals(expected, solution510.inorderSuccessor(node));
    }
}
// TODO