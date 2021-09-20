import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution92Tests {
    private final Solution92 solution92 = new Solution92();

    @Test
    public void example1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int left = 2;
        int right = 4;
        // expected
        ListNode expected = new ListNode(1);
        expected.next = new ListNode(4);
        expected.next.next = new ListNode(3);
        expected.next.next.next = new ListNode(2);
        expected.next.next.next.next = new ListNode(5);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution92.reverseBetween(head, left, right)));
    }

    @Test
    public void example2() {
        ListNode head = new ListNode(5);
        int left = 1;
        int right = 1;
        // expected
        ListNode expected = new ListNode(5);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution92.reverseBetween(head, left, right)));
    }
}
