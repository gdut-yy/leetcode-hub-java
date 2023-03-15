import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0201Tests {
    private final SolutionI0201 solutionI0201 = new SolutionI0201();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 3, 2, 1});
        ListNode expected = ListNode.buildListNode(new int[]{1, 2, 3});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionI0201.removeDuplicateNodes(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 1, 1, 1, 2});
        ListNode expected = ListNode.buildListNode(new int[]{1, 2});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionI0201.removeDuplicateNodes(head)));
    }
}
