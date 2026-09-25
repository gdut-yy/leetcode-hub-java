import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Cnunionpay220916T1Tests {
    private final Cnunionpay220916T1 cnunionpay220916T1 = new Cnunionpay220916T1();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 4, 3, 6});
        ListNode expected = ListNode.buildListNode(new int[]{1, 3});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, cnunionpay220916T1.reContruct(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{5, 7, 9, 9, 1});
        ListNode expected = ListNode.buildListNode(new int[]{5, 7, 9, 9, 1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, cnunionpay220916T1.reContruct(head)));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{2, 4});
        ListNode expected = ListNode.buildListNode(new int[]{});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, cnunionpay220916T1.reContruct(head)));
    }
}
