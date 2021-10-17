import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO25Tests {
    private final SolutionO25 solutionO25 = new SolutionO25();

    @Test
    public void example1() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        // expected
        ListNode expected = new ListNode(1);
        expected.next = new ListNode(1);
        expected.next.next = new ListNode(2);
        expected.next.next.next = new ListNode(3);
        expected.next.next.next.next = new ListNode(4);
        expected.next.next.next.next.next = new ListNode(4);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionO25.mergeTwoLists(l1, l2)));
    }
}
