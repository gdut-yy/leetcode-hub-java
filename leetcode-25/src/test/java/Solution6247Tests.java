import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6247Tests {
    private final Solution6247 solution6247 = new Solution6247();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{5, 2, 13, 3, 8});
        ListNode expected = ListNode.buildListNode(new int[]{13, 8});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution6247.removeNodes(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 1, 1, 1});
        ListNode expected = ListNode.buildListNode(new int[]{1, 1, 1, 1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution6247.removeNodes(head)));
    }
}
