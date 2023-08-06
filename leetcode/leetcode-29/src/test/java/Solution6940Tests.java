import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6940Tests {
    private final Solution6940 solution6940 = new Solution6940();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{18, 6, 10, 3});
        ListNode expected = ListNode.buildListNode(new int[]{18, 6, 6, 2, 10, 1, 3});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution6940.insertGreatestCommonDivisors(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{7});
        ListNode expected = ListNode.buildListNode(new int[]{7});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution6940.insertGreatestCommonDivisors(head)));
    }
}