import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1836Tests {
    private final Solution1836 solution1836 = new Solution1836();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 2});
        ListNode expected = ListNode.buildListNode(new int[]{1, 3});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution1836.deleteDuplicatesUnsorted(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{2, 1, 1, 2});
        ListNode expected = ListNode.buildListNode(new int[]{});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution1836.deleteDuplicatesUnsorted(head)));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{3, 2, 2, 1, 3, 2, 4});
        ListNode expected = ListNode.buildListNode(new int[]{1, 4});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution1836.deleteDuplicatesUnsorted(head)));
    }
}
