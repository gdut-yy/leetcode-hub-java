import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO22Tests {
    private final SolutionO22 solutionO22 = new SolutionO22();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        int k = 2;
        ListNode expected = ListNode.buildListNode(new int[]{4, 5});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionO22.getKthFromEnd(head, k)));
    }
}
