import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution141Tests {
    private final Solution141 solution141 = new Solution141();

    @Test
    public void example1() {
        Solution141.ListNode head = new Solution141.ListNode(3);
        head.next = new Solution141.ListNode(2);
        head.next.next = new Solution141.ListNode(0);
        head.next.next.next = new Solution141.ListNode(-4);
        head.next.next.next.next = head.next;
        Assertions.assertTrue(solution141.hasCycle(head));
    }

    @Test
    public void example2() {
        Solution141.ListNode head = new Solution141.ListNode(1);
        head.next = new Solution141.ListNode(2);
        head.next.next = head;
        Assertions.assertTrue(solution141.hasCycle(head));
    }

    @Test
    public void example3() {
        Solution141.ListNode head = new Solution141.ListNode(1);
        Assertions.assertFalse(solution141.hasCycle(head));
    }
}
