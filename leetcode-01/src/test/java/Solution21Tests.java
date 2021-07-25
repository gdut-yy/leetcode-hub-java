import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution21Tests {
    private final Solution21 solution21 = new Solution21();

    @Test
    public void example1() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        // expected
        ListNode expected = new ListNode(1);
        expected.next = new ListNode(1);
        expected.next.next = new ListNode(2);
        expected.next.next.next = new ListNode(3);
        expected.next.next.next.next = new ListNode(4);
        expected.next.next.next.next.next = new ListNode(4);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution21.mergeTwoLists(l1, l2)));
    }

    @Test
    public void example2() {
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode expected = null;
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution21.mergeTwoLists(l1, l2)));
    }

    @Test
    public void example3() {
        ListNode l1 = null;
        ListNode l2 = new ListNode(0);
        ListNode expected = new ListNode(0);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution21.mergeTwoLists(l1, l2)));
    }
}
