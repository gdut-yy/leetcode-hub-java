import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO06Tests {
    private final SolutionO06 solutionO06 = new SolutionO06();

    @Test
    public void example1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        int[] expected = {2, 3, 1};
        Assertions.assertArrayEquals(expected, solutionO06.reversePrint(head));
    }
}
