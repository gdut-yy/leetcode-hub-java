import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution23Tests {

    private final Solution23 solution23 = new Solution23();

    @Test
    public void example1() {
        Solution23.ListNode listNode1;
        listNode1 = new Solution23.ListNode(1);
        listNode1.next = new Solution23.ListNode(4);
        listNode1.next.next = new Solution23.ListNode(5);
        Solution23.ListNode listNode2;
        listNode2 = new Solution23.ListNode(1);
        listNode2.next = new Solution23.ListNode(3);
        listNode2.next.next = new Solution23.ListNode(4);
        Solution23.ListNode listNode3;
        listNode3 = new Solution23.ListNode(2);
        listNode3.next = new Solution23.ListNode(6);
        Solution23.ListNode[] lists = {listNode1, listNode2, listNode3};
        // expected
        Solution23.ListNode expected;
        expected = new Solution23.ListNode(1);
        expected.next = new Solution23.ListNode(1);
        expected.next.next = new Solution23.ListNode(2);
        expected.next.next.next = new Solution23.ListNode(3);
        expected.next.next.next.next = new Solution23.ListNode(4);
        expected.next.next.next.next.next = new Solution23.ListNode(4);
        expected.next.next.next.next.next.next = new Solution23.ListNode(5);
        expected.next.next.next.next.next.next.next = new Solution23.ListNode(6);
        Assertions.assertEquals(expected, solution23.mergeKLists(lists));
    }

    @Test
    public void example2() {
        Solution23.ListNode[] lists = {};
        // expected
        Solution23.ListNode expected = null;
        Assertions.assertEquals(expected, solution23.mergeKLists(lists));
    }

    @Test
    public void example3() {
        Solution23.ListNode[] lists = {null};
        // expected
        Solution23.ListNode expected = null;
        Assertions.assertEquals(expected, solution23.mergeKLists(lists));
    }
}
