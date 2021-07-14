import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution876Tests {
    private final Solution876 solution876 = new Solution876();

    @Test
    public void example1() {
        Solution876.ListNode head;
        head = new Solution876.ListNode(1);
        head.next = new Solution876.ListNode(2);
        head.next.next = new Solution876.ListNode(3);
        head.next.next.next = new Solution876.ListNode(4);
        head.next.next.next.next = new Solution876.ListNode(5);
        // expected
        Solution876.ListNode expected = head.next.next;
        Assertions.assertEquals(expected, solution876.middleNode(head));
    }

    @Test
    public void example2() {
        Solution876.ListNode head;
        head = new Solution876.ListNode(1);
        head.next = new Solution876.ListNode(2);
        head.next.next = new Solution876.ListNode(3);
        head.next.next.next = new Solution876.ListNode(4);
        head.next.next.next.next = new Solution876.ListNode(5);
        head.next.next.next.next.next = new Solution876.ListNode(6);
        // expected
        Solution876.ListNode expected = head.next.next.next;
        Assertions.assertEquals(expected, solution876.middleNode(head));
    }
}
