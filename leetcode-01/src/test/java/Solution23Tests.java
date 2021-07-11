import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution23Tests {

    private final Solution23 solution23 = new Solution23();

    @Test
    public void example1() {
        Solution23.ListNode[] lists = {
                new Solution23.ListNode(1,
                        new Solution23.ListNode(4,
                                new Solution23.ListNode(5)
                        )
                ),
                new Solution23.ListNode(1,
                        new Solution23.ListNode(3,
                                new Solution23.ListNode(4)
                        )
                ),
                new Solution23.ListNode(2,
                        new Solution23.ListNode(6)
                ),
        };
        Solution23.ListNode expected =
                new Solution23.ListNode(1,
                        new Solution23.ListNode(1,
                                new Solution23.ListNode(2,
                                        new Solution23.ListNode(3,
                                                new Solution23.ListNode(4,
                                                        new Solution23.ListNode(4,
                                                                new Solution23.ListNode(5,
                                                                        new Solution23.ListNode(6)
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                );
        Assertions.assertEquals(expected, solution23.mergeKLists(lists));
    }

    @Test
    public void example2() {
        Solution23.ListNode[] lists = {};
        Solution23.ListNode expected = null;
        Assertions.assertEquals(expected, solution23.mergeKLists(lists));
    }

    @Test
    public void example3() {
        Solution23.ListNode[] lists = {null};
        Solution23.ListNode expected = null;
        Assertions.assertEquals(expected, solution23.mergeKLists(lists));
    }
}
