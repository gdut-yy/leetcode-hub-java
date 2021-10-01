import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0203Tests {
    private final SolutionI0203 solutionI0203 = new SolutionI0203();

    @Test
    public void example1() {
        ListNode head = new ListNode(5);
        head.next = new ListNode(1);
        head.next.next = new ListNode(9);

        ListNode expected = new ListNode(1);
        expected.next = new ListNode(9);
        solutionI0203.deleteNode(head);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, head));
    }
}
