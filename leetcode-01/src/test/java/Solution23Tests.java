import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution23Tests {

    private final Solution23 solution23 = new Solution23();

    @Test
    public void example1() {
        ListNode listNode1;
        listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);
        ListNode listNode2;
        listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        ListNode listNode3;
        listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);
        ListNode[] lists = {listNode1, listNode2, listNode3};
        // expected
        ListNode expected;
        expected = new ListNode(1);
        expected.next = new ListNode(1);
        expected.next.next = new ListNode(2);
        expected.next.next.next = new ListNode(3);
        expected.next.next.next.next = new ListNode(4);
        expected.next.next.next.next.next = new ListNode(4);
        expected.next.next.next.next.next.next = new ListNode(5);
        expected.next.next.next.next.next.next.next = new ListNode(6);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution23.mergeKLists(lists)));
    }

    @Test
    public void example2() {
        ListNode[] lists = {};
        // expected
        ListNode expected = null;
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution23.mergeKLists(lists)));
    }

    @Test
    public void example3() {
        ListNode[] lists = {null};
        // expected
        ListNode expected = null;
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution23.mergeKLists(lists)));
    }
}
