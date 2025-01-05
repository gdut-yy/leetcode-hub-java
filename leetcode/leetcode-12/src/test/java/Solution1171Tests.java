import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1171Tests {
    private final Solution1171 solution1171 = new Solution1171();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, -3, 3, 1});
        ListNode expected = ListNode.buildListNode(new int[]{3, 1});
        // 答案 [1,2,1] 也是正确的。
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution1171.removeZeroSumSublists(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, -3, 4});
        ListNode expected = ListNode.buildListNode(new int[]{1, 2, 4});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution1171.removeZeroSumSublists(head)));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, -3, -2});
        ListNode expected = ListNode.buildListNode(new int[]{1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution1171.removeZeroSumSublists(head)));
    }
}