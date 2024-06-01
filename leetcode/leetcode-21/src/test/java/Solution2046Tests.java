import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2046Tests {
    private final Solution2046 solution2046 = new Solution2046();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{0, 2, -5, 5, 10, -10});
        ListNode expected = ListNode.buildListNode(new int[]{-10, -5, 0, 2, 5, 10});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2046.sortLinkedList(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{0, 1, 2});
        ListNode expected = ListNode.buildListNode(new int[]{0, 1, 2});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2046.sortLinkedList(head)));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{1});
        ListNode expected = ListNode.buildListNode(new int[]{1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2046.sortLinkedList(head)));
    }
}