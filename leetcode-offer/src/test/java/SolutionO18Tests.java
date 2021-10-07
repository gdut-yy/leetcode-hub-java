import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO18Tests {
    private final SolutionO18 solutionO18 = new SolutionO18();

    @Test
    public void example1() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        int val = 5;
        // expected
        ListNode expected = new ListNode(4);
        expected.next = new ListNode(1);
        expected.next.next = new ListNode(9);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionO18.deleteNode(head, val)));
    }

    @Test
    public void example2() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        int val = 1;
        // expected
        ListNode expected = new ListNode(4);
        expected.next = new ListNode(5);
        expected.next.next = new ListNode(9);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionO18.deleteNode(head, val)));
    }

    @Test
    public void example3() {
        ListNode head = new ListNode(-3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(-99);
        int val = -3;
        // expected
        ListNode expected = new ListNode(5);
        expected.next = new ListNode(-99);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionO18.deleteNode(head, val)));
    }
}
