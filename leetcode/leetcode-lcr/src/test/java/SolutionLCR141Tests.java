import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR141Tests {
    private final SolutionLCR141 solutionLCR141 = new SolutionLCR141();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode expected = ListNode.buildListNode(new int[]{5, 4, 3, 2, 1});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionLCR141.trainningPlan(head)));
    }
}
