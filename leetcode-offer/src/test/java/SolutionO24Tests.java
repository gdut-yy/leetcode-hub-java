import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO24Tests {
    private final SolutionO24 solutionO24 = new SolutionO24();

    @Test
    public void example1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        // expected
        ListNode expected = new ListNode(5);
        expected.next = new ListNode(4);
        expected.next.next = new ListNode(3);
        expected.next.next.next = new ListNode(2);
        expected.next.next.next.next = new ListNode(1);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionO24.reverseList(head)));
    }
}
