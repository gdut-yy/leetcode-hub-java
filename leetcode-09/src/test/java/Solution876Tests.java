import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution876Tests {
    private final Solution876 solution876 = new Solution876();

    @Test
    public void example1() {
        ListNode head;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        // expected
        ListNode expected = head.next.next;
        Assertions.assertEquals(expected, solution876.middleNode(head));
    }

    @Test
    public void example2() {
        ListNode head;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        // expected
        ListNode expected = head.next.next.next;
        Assertions.assertEquals(expected, solution876.middleNode(head));
    }
}
