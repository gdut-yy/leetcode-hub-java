import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO22Tests {
    private final SolutionO22 solutionO22 = new SolutionO22();

    @Test
    public void example1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        // expected
        ListNode expected = new ListNode(4);
        expected.next = new ListNode(5);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionO22.getKthFromEnd(head, k)));
    }
}
