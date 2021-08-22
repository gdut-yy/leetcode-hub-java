import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution143Tests {
    private final Solution143 solution143 = new Solution143();

    @Test
    public void example1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        // expected
        ListNode expected = new ListNode(1);
        expected.next = new ListNode(4);
        expected.next.next = new ListNode(2);
        expected.next.next.next = new ListNode(3);

        solution143.reorderList(head);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, head));
    }

    @Test
    public void example2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        // expected
        ListNode expected = new ListNode(1);
        expected.next = new ListNode(5);
        expected.next.next = new ListNode(2);
        expected.next.next.next = new ListNode(4);
        expected.next.next.next.next = new ListNode(3);

        solution143.reorderList(head);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, head));
    }
}
