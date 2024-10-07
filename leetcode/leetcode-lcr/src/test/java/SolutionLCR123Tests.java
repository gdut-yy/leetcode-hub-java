import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR123Tests {
    private final SolutionLCR123 solutionLCR123 = new SolutionLCR123();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 3, 2});
        int[] expected = {2, 3, 1};
        Assertions.assertArrayEquals(expected, solutionLCR123.reverseBookList(head));
    }
}
