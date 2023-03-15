import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO06Tests {
    private final SolutionO06 solutionO06 = new SolutionO06();

    @Test
    public void example1() {
        ListNode head = ListNode.buildListNode(new int[]{1, 3, 2});
        int[] expected = {2, 3, 1};
        Assertions.assertArrayEquals(expected, solutionO06.reversePrint(head));
    }
}
