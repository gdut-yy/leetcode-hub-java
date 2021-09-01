import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution82Tests {
    private final Solution82 solution82 = new Solution82();

    @Test
    public void example1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        // expected
        ListNode expected = new ListNode(1);
        expected.next = new ListNode(2);
        expected.next.next = new ListNode(5);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution82.deleteDuplicates(head)));
    }

    @Test
    public void example2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        // expected
        ListNode expected = new ListNode(2);
        expected.next = new ListNode(3);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution82.deleteDuplicates(head)));
    }
}
