import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution142Tests {
    private final Solution142 solution142 = new Solution142();

    @Test
    public void example1() {
        Solution142.ListNode head = new Solution142.ListNode(3);
        head.next = new Solution142.ListNode(2);
        head.next.next = new Solution142.ListNode(0);
        head.next.next.next = new Solution142.ListNode(-4);
        head.next.next.next.next = head.next;
        // expected
        Solution142.ListNode expected = head.next;
        Assertions.assertEquals(expected, solution142.detectCycle(head));
    }

    @Test
    public void example2() {
        Solution142.ListNode head = new Solution142.ListNode(1);
        head.next = new Solution142.ListNode(2);
        head.next.next = head;
        // expected
        Solution142.ListNode expected = head;
        Assertions.assertEquals(expected, solution142.detectCycle(head));
    }

    @Test
    public void example3() {
        Solution142.ListNode head = new Solution142.ListNode(1);
        // expected
        Solution142.ListNode expected = null;
        Assertions.assertEquals(expected, solution142.detectCycle(head));
    }
}
