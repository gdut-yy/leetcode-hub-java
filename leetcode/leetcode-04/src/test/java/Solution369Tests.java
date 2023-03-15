import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution369Tests {
    private final Solution369 solution369 = new Solution369();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3});
        ListNode expected = ListNode.buildListNode(new int[]{1, 2, 4});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution369.plusOne(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{0});
        ListNode expected = ListNode.buildListNode(new int[]{1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution369.plusOne(head)));
    }
}
