import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0205Tests {
    private final SolutionI0205 solutionI0205 = new SolutionI0205();

    @Test
    public void example1() {
        ListNode l1 = ListNode.buildListNode(new int[]{7, 1, 6});
        ListNode l2 = ListNode.buildListNode(new int[]{5, 9, 2});
        ListNode expected = ListNode.buildListNode(new int[]{2, 1, 9});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionI0205.addTwoNumbers(l1, l2)));
    }
}
