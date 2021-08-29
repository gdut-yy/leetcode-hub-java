import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution148Tests {
    private final Solution148 solution148 = new Solution148();

    @Test
    public void example1() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        // expected
        ListNode expected = new ListNode(1);
        expected.next = new ListNode(2);
        expected.next.next = new ListNode(3);
        expected.next.next.next = new ListNode(4);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution148.sortList(head)));
    }

    @Test
    public void example2() {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        // expected
        ListNode expected = new ListNode(-1);
        expected.next = new ListNode(0);
        expected.next.next = new ListNode(3);
        expected.next.next.next = new ListNode(4);
        expected.next.next.next.next = new ListNode(5);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution148.sortList(head)));
    }
}
