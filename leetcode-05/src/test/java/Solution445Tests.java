import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution445Tests {
    private final Solution445 solution445 = new Solution445();

    @Test
    public void example1() {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        // expected
        ListNode expected = new ListNode(7);
        expected.next = new ListNode(8);
        expected.next.next = new ListNode(0);
        expected.next.next.next = new ListNode(7);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution445.addTwoNumbers(l1, l2)));
    }

    @Test
    public void example2() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        // expected
        ListNode expected = new ListNode(8);
        expected.next = new ListNode(0);
        expected.next.next = new ListNode(7);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution445.addTwoNumbers(l1, l2)));
    }

    @Test
    public void example3() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        // expected
        ListNode expected = new ListNode(0);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution445.addTwoNumbers(l1, l2)));
    }
}
