import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR142Tests {
    private final SolutionLCR142 solutionLCR142 = new SolutionLCR142();

    @Test
    public void example1() {
        ListNode l1 = ListNode.buildListNode(new int[]{1, 2, 4});
        ListNode l2 = ListNode.buildListNode(new int[]{1, 3, 4});
        ListNode expected = ListNode.buildListNode(new int[]{1, 1, 2, 3, 4, 4});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionLCR142.trainningPlan(l1, l2)));
    }
}
