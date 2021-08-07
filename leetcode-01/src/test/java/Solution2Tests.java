import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2Tests {
    private final Solution2 solution2 = new Solution2();

    @Test
    public void example1() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        // expected
        ListNode expected = new ListNode(7);
        expected.next = new ListNode(0);
        expected.next.next = new ListNode(8);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2.addTwoNumbers(l1, l2)));
    }

    @Test
    public void example2() {
        ListNode l1 = new ListNode(0);

        ListNode l2 = new ListNode(0);
        // expected
        ListNode expected = new ListNode(0);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2.addTwoNumbers(l1, l2)));
    }

    @Test
    public void example3() {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        // expected
        ListNode expected = new ListNode(8);
        expected.next = new ListNode(9);
        expected.next.next = new ListNode(9);
        expected.next.next.next = new ListNode(9);
        expected.next.next.next.next = new ListNode(0);
        expected.next.next.next.next.next = new ListNode(0);
        expected.next.next.next.next.next.next = new ListNode(0);
        expected.next.next.next.next.next.next.next = new ListNode(1);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2.addTwoNumbers(l1, l2)));
    }
}
