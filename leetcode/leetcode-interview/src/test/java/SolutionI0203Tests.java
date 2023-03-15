import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0203Tests {
    private final SolutionI0203 solutionI0203 = new SolutionI0203();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{5, 1, 9});
        ListNode expected = ListNode.buildListNode(new int[]{1, 9});
        solutionI0203.deleteNode(head);
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, head));
    }
}
