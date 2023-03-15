import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution510Tests {
    private final Solution510 solution510 = new Solution510();

    @Test
    public void example1() {
        // 输入：tree = [2,1,3], node = 1
        // 输出：2
        Solution510.Node node = new Solution510.Node(2);
        node.left = new Solution510.Node(1, node);
        node.right = new Solution510.Node(3, node);
        Solution510.Node expected = node.right;
        Assertions.assertEquals(expected, solution510.inorderSuccessor(node));
    }

    @Test
    public void example2() {
        // 输入：tree = [5,3,6,2,4,null,null,1], node = 6
        // 输出：null
        Solution510.Node node = new Solution510.Node(5);
        node.left = new Solution510.Node(3, node);
        node.right = new Solution510.Node(6, node);
        node.left.left = new Solution510.Node(2, node.left);
        node.left.right = new Solution510.Node(4, node.left);
        node.left.left.left = new Solution510.Node(1, node.left.left);
        Solution510.Node expected = null;
        Assertions.assertEquals(expected, solution510.inorderSuccessor(node.right));
    }

    @Test
    public void example3() {
        // 输入：tree = [15,6,18,3,7,17,20,2,4,null,13,null,null,null,null,null,null,null,null,9], node = 15
        // 输出：17
        Solution510.Node node = new Solution510.Node(15);
        node.left = new Solution510.Node(6, node);
        node.right = new Solution510.Node(18, node);
        node.left.left = new Solution510.Node(3, node.left);
        node.left.right = new Solution510.Node(7, node.left);
        node.right.left = new Solution510.Node(17, node.right);
        node.right.right = new Solution510.Node(20, node.right);
        node.left.left.left = new Solution510.Node(2, node.left.left);
        node.left.left.right = new Solution510.Node(4, node.left.left);
        node.left.right.right = new Solution510.Node(13, node.left.right);
        node.left.right.right.left = new Solution510.Node(9, node.left.right.right);
        Solution510.Node expected = node.right.left;
        Assertions.assertEquals(expected, solution510.inorderSuccessor(node));
    }

    @Test
    public void example4() {
        // 输入：tree = [15,6,18,3,7,17,20,2,4,null,13,null,null,null,null,null,null,null,null,9], node = 13
        // 输出：15
        Solution510.Node node = new Solution510.Node(15);
        node.left = new Solution510.Node(6, node);
        node.right = new Solution510.Node(18, node);
        node.left.left = new Solution510.Node(3, node.left);
        node.left.right = new Solution510.Node(7, node.left);
        node.right.left = new Solution510.Node(17, node.right);
        node.right.right = new Solution510.Node(20, node.right);
        node.left.left.left = new Solution510.Node(2, node.left.left);
        node.left.left.right = new Solution510.Node(4, node.left.left);
        node.left.right.right = new Solution510.Node(13, node.left.right);
        node.left.right.right.left = new Solution510.Node(9, node.left.right.right);
        Solution510.Node expected = node;
        Assertions.assertEquals(expected, solution510.inorderSuccessor(node.left.right.right));
    }

    @Test
    public void example5() {
        // 输入：tree = [0], node = 0
        // 输出：null
        Solution510.Node node = new Solution510.Node(0);
        Solution510.Node expected = null;
        Assertions.assertEquals(expected, solution510.inorderSuccessor(node));
    }
}