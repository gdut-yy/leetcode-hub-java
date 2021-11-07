import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Jianxin001Tests {
    private final Jianxin001 jianxin001 = new Jianxin001();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4});
        ListNode expected = ListNode.buildListNode(new int[]{1, 3});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, jianxin001.deleteListNode(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{5, 1, 8, 6, 1});
        ListNode expected = ListNode.buildListNode(new int[]{5, 8, 1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, jianxin001.deleteListNode(head)));
    }
}
