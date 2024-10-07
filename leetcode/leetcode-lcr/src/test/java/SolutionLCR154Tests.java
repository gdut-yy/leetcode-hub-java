import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR154Tests {
    private final SolutionLCR154 solutionLCR154 = new SolutionLCR154();

    @Test
    public void example1() {
        SolutionLCR154.Node head = new SolutionLCR154.Node(7);
        SolutionLCR154.Node node1 = new SolutionLCR154.Node(13);
        SolutionLCR154.Node node2 = new SolutionLCR154.Node(11);
        SolutionLCR154.Node node3 = new SolutionLCR154.Node(10);
        SolutionLCR154.Node node4 = new SolutionLCR154.Node(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        head.random = null;
        node1.random = head;
        node2.random = node4;
        node3.random = node2;
        node4.random = head;
        Assertions.assertTrue(UtUtils.assertJsonEquals(head, solutionLCR154.copyRandomList(head)));
    }

    @Test
    public void example2() {
        SolutionLCR154.Node head = new SolutionLCR154.Node(1);
        SolutionLCR154.Node node1 = new SolutionLCR154.Node(2);
        head.next = node1;
        node1.next = null;
        head.random = node1;
        node1.random = node1;
        Assertions.assertTrue(UtUtils.assertJsonEquals(head, solutionLCR154.copyRandomList(head)));
    }

    @Test
    public void example3() {
        SolutionLCR154.Node head = new SolutionLCR154.Node(3);
        SolutionLCR154.Node node1 = new SolutionLCR154.Node(3);
        SolutionLCR154.Node node2 = new SolutionLCR154.Node(3);
        head.next = node1;
        node1.next = node2;
        node2.next = null;
        head.random = null;
        node1.random = head;
        node2.random = null;
        Assertions.assertTrue(UtUtils.assertJsonEquals(head, solutionLCR154.copyRandomList(head)));
    }

    @Test
    public void example4() {
        SolutionLCR154.Node head = null;
        Assertions.assertTrue(UtUtils.assertJsonEquals(head, solutionLCR154.copyRandomList(head)));
    }
}
