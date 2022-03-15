import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Yinlian001Tests {
    private final Yinlian001 yinlian001 = new Yinlian001();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 2, 3, 1});
        Assertions.assertTrue(yinlian001.isPalindrome(head));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{5, 1, 8, 8, 1, 5});
        Assertions.assertTrue(yinlian001.isPalindrome(head));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4});
        Assertions.assertFalse(yinlian001.isPalindrome(head));
    }
}
