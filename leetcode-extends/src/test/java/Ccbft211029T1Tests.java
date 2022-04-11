import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Ccbft211029T1Tests {
    private final Ccbft211029T1 ccbft211029T1 = new Ccbft211029T1();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4});
        ListNode expected = ListNode.buildListNode(new int[]{1, 3});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, ccbft211029T1.deleteListNode(head)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{5, 1, 8, 6, 1});
        ListNode expected = ListNode.buildListNode(new int[]{5, 8, 1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, ccbft211029T1.deleteListNode(head)));
    }
}
