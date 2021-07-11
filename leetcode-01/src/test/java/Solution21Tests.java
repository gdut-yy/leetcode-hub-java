import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution21Tests {
    private final Solution21 solution21 = new Solution21();

    @Test
    public void example1() {
        Solution21.ListNode l1 =
                new Solution21.ListNode(1,
                        new Solution21.ListNode(2,
                                new Solution21.ListNode(4)
                        )
                );
        Solution21.ListNode l2 =
                new Solution21.ListNode(1,
                        new Solution21.ListNode(3,
                                new Solution21.ListNode(4)
                        )
                );
        Solution21.ListNode expected =
                new Solution21.ListNode(1,
                        new Solution21.ListNode(1,
                                new Solution21.ListNode(2,
                                        new Solution21.ListNode(3,
                                                new Solution21.ListNode(4,
                                                        new Solution21.ListNode(4)
                                                )
                                        )
                                )
                        )
                );
        Assertions.assertEquals(expected, solution21.mergeTwoLists(l1, l2));
    }

    @Test
    public void example2() {
        Solution21.ListNode l1 = null;
        Solution21.ListNode l2 = null;
        Solution21.ListNode expected = null;
        Assertions.assertEquals(expected, solution21.mergeTwoLists(l1, l2));
    }

    @Test
    public void example3() {
        Solution21.ListNode l1 = null;
        Solution21.ListNode l2 = new Solution21.ListNode(0);
        Solution21.ListNode expected = new Solution21.ListNode(0);
        Assertions.assertEquals(expected, solution21.mergeTwoLists(l1, l2));
    }
}
