import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Cnunionpay220313T1Tests {
    private final Cnunionpay220313T1 cnunionpay220313T1 = new Cnunionpay220313T1();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 2, 3, 1});
        Assertions.assertTrue(cnunionpay220313T1.isPalindrome(head));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{5, 1, 8, 8, 1, 5});
        Assertions.assertTrue(cnunionpay220313T1.isPalindrome(head));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4});
        Assertions.assertFalse(cnunionpay220313T1.isPalindrome(head));
    }
}
