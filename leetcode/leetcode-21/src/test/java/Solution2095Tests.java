import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2095Tests {
    private final Solution2095.V1 solution2095_v1 = new Solution2095.V1();
    private final Solution2095.V2 solution2095_v2 = new Solution2095.V2();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 3, 4, 7, 1, 2, 6});
        ListNode expected = ListNode.buildListNode(new int[]{1, 3, 4, 1, 2, 6});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2095_v1.deleteMiddle(head)));
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2095_v2.deleteMiddle(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4});
        ListNode expected = ListNode.buildListNode(new int[]{1, 2, 4});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2095_v1.deleteMiddle(head)));
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2095_v2.deleteMiddle(head)));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{2, 1});
        ListNode expected = ListNode.buildListNode(new int[]{2});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2095_v1.deleteMiddle(head)));
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solution2095_v2.deleteMiddle(head)));
    }
}
