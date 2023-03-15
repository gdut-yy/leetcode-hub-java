import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0202Tests {
    private final SolutionI0202 solutionI0202 = new SolutionI0202();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solutionI0202.kthToLast(head, k));
    }

    // 补充用例
    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{1});
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solutionI0202.kthToLast(head, k));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{1, 2});
        int k = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solutionI0202.kthToLast(head, k));
    }
}
