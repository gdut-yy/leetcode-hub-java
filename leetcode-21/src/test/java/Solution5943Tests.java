import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5943Tests {
    private final Solution5943 solution5943 = new Solution5943();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 3, 4, 7, 1, 2, 6});
        ListNode expected = ListNode.buildListNode(new int[]{1, 3, 4, 1, 2, 6});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution5943.deleteMiddle(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4});
        ListNode expected = ListNode.buildListNode(new int[]{1, 2, 4});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution5943.deleteMiddle(head)));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{2, 1});
        ListNode expected = ListNode.buildListNode(new int[]{2});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution5943.deleteMiddle(head)));
    }
}
