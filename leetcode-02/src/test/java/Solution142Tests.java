import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution142Tests {
    private final Solution142 solution142 = new Solution142();

    @Test
    public void example1() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        // expected
        ListNode expected = head.next;
        Assertions.assertEquals(expected, solution142.detectCycle(head));
    }

    @Test
    public void example2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        // expected
        ListNode expected = head;
        Assertions.assertEquals(expected, solution142.detectCycle(head));
    }

    @Test
    public void example3() {
        ListNode head = new ListNode(1);
        // expected
        ListNode expected = null;
        Assertions.assertEquals(expected, solution142.detectCycle(head));
    }
}
