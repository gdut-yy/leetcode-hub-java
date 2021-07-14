import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution19Tests {
    private final Solution19 solution19 = new Solution19();

    @Test
    public void example1() {
        Solution19.ListNode head;
        head = new Solution19.ListNode(1);
        head.next = new Solution19.ListNode(2);
        head.next.next = new Solution19.ListNode(3);
        head.next.next.next = new Solution19.ListNode(4);
        head.next.next.next.next = new Solution19.ListNode(5);
        int n = 2;
        // expected
        Solution19.ListNode expected;
        expected = new Solution19.ListNode(1);
        expected.next = new Solution19.ListNode(2);
        expected.next.next = new Solution19.ListNode(3);
        expected.next.next.next = new Solution19.ListNode(5);
        Assertions.assertEquals(expected, solution19.removeNthFromEnd(head, n));
    }

    @Test
    public void example2() {
        Solution19.ListNode head = new Solution19.ListNode(1);
        int n = 1;
        // expected
        Solution19.ListNode expected = null;
        Assertions.assertEquals(expected, solution19.removeNthFromEnd(head, n));
    }

    @Test
    public void example3() {
        Solution19.ListNode head;
        head = new Solution19.ListNode(1);
        head.next = new Solution19.ListNode(2);
        int n = 1;
        // expected
        Solution19.ListNode expected = new Solution19.ListNode(1);
        Assertions.assertEquals(expected, solution19.removeNthFromEnd(head, n));
    }
}
