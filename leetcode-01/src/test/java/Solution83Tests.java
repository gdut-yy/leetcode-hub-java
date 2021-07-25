import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution83Tests {
    private final Solution83 solution83 = new Solution83();

    @Test
    public void example1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        // expected
        ListNode expected = new ListNode(1);
        expected.next = new ListNode(2);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution83.deleteDuplicates(head)));
    }

    @Test
    public void example2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        // expected
        ListNode expected = new ListNode(1);
        expected.next = new ListNode(2);
        expected.next.next = new ListNode(3);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution83.deleteDuplicates(head)));
    }
}
