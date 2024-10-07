import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR140Tests {
    private final SolutionLCR140 solutionLCR140 = new SolutionLCR140();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        int k = 2;
        ListNode expected = ListNode.buildListNode(new int[]{4, 5});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionLCR140.trainingPlan(head, k)));
    }
}
