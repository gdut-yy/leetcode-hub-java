import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0208Tests {
    private final SolutionI0208 solutionI0208 = new SolutionI0208();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{3, 2, 0, -4});
        head.next.next.next.next = head.next;
        ListNode expected = head.next;
        Assertions.assertEquals(expected, solutionI0208.detectCycle(head));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2});
        head.next.next = head;
        ListNode expected = head;
        Assertions.assertEquals(expected, solutionI0208.detectCycle(head));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{1});
        ListNode expected = null;
        Assertions.assertEquals(expected, solutionI0208.detectCycle(head));
    }
}
