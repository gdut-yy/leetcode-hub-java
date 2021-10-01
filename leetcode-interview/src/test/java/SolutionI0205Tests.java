import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0205Tests {
    private final SolutionI0205 solutionI0205 = new SolutionI0205();

    @Test
    public void example1() {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(2);

        ListNode expected = new ListNode(2);
        expected.next = new ListNode(1);
        expected.next.next = new ListNode(9);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionI0205.addTwoNumbers(l1, l2)));
    }
}
