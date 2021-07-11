import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution83Tests {
    private final Solution83 solution83 = new Solution83();

    @Test
    public void example1() {
        Solution83.ListNode head =
                new Solution83.ListNode(1,
                        new Solution83.ListNode(1,
                                new Solution83.ListNode(2)
                        )
                );
        Solution83.ListNode expected =
                new Solution83.ListNode(1,
                        new Solution83.ListNode(2)
                );
        Assertions.assertEquals(expected, solution83.deleteDuplicates(head));
    }

    @Test
    public void example2() {
        Solution83.ListNode head =
                new Solution83.ListNode(1,
                        new Solution83.ListNode(1,
                                new Solution83.ListNode(2,
                                        new Solution83.ListNode(3,
                                                new Solution83.ListNode(3)
                                        )
                                )
                        )
                );
        Solution83.ListNode expected =
                new Solution83.ListNode(1,
                        new Solution83.ListNode(2,
                                new Solution83.ListNode(3)
                        )
                );
        Assertions.assertEquals(expected, solution83.deleteDuplicates(head));
    }
}
