import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO18Tests {
    private final SolutionO18 solutionO18 = new SolutionO18();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{4, 5, 1, 9});
        int val = 5;
        ListNode expected = ListNode.buildListNode(new int[]{4, 1, 9});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionO18.deleteNode(head, val)));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{4, 5, 1, 9});
        int val = 1;
        ListNode expected = ListNode.buildListNode(new int[]{4, 5, 9});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionO18.deleteNode(head, val)));
    }

    // 补充用例
    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{-3, 5, -99});
        int val = -3;
        ListNode expected = ListNode.buildListNode(new int[]{5, -99});
        Assertions.assertTrue(ListNode.assertListNodeEquals(expected, solutionO18.deleteNode(head, val)));
    }
}
