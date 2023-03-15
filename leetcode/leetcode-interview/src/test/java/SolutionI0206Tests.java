import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0206Tests {
    private final SolutionI0206 solutionI0206 = new SolutionI0206();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2});
        Assertions.assertFalse(solutionI0206.isPalindrome(head));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 2, 1});
        Assertions.assertTrue(solutionI0206.isPalindrome(head));
    }
}
