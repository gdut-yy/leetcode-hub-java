import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5961Tests {
    private final Solution5961 solution5961 = new Solution5961();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{5, 4, 2, 1});
        int expected = 6;
        Assertions.assertEquals(expected, solution5961.pairSum(head));
    }

    @Test
    public void example2() {
        ListNode head = ListNode.buildListNode(new int[]{4, 2, 2, 3});
        int expected = 7;
        Assertions.assertEquals(expected, solution5961.pairSum(head));
    }

    @Test
    public void example3() {
        ListNode head = ListNode.buildListNode(new int[]{1, 100000});
        int expected = 100001;
        Assertions.assertEquals(expected, solution5961.pairSum(head));
    }
}
