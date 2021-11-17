import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0403Tests {
    private final SolutionI0403 solutionI0403 = new SolutionI0403();

    @Test
    public void example1() {
        TreeNode tree = TreeNode.buildTreeNode("[1,2,3,4,5,null,7,8]");
        ListNode[] expected = new ListNode[]{
                ListNode.buildListNode(new int[]{1}),
                ListNode.buildListNode(new int[]{2, 3}),
                ListNode.buildListNode(new int[]{4, 5, 7}),
                ListNode.buildListNode(new int[]{8})
        };
        ListNode[] actual = solutionI0403.listOfDepth(tree);
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, actual));
    }
}
