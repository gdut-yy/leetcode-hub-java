import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0201Tests {
    private final SolutionI0201 solutionI0201 = new SolutionI0201();

    @Test
    public void example1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        // expected
        ListNode expected = new ListNode(1);
        expected.next = new ListNode(2);
        expected.next.next = new ListNode(3);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionI0201.removeDuplicateNodes(head)));
    }

    @Test
    public void example2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        // expected
        ListNode expected = new ListNode(1);
        expected.next = new ListNode(2);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionI0201.removeDuplicateNodes(head)));
    }
}
