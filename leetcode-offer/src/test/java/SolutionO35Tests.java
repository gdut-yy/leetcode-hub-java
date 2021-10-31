import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO35Tests {
    private final SolutionO35 solutionO35 = new SolutionO35();

    @Test
    public void example1() {
        SolutionO35.Node head = new SolutionO35.Node(7);
        SolutionO35.Node node1 = new SolutionO35.Node(13);
        SolutionO35.Node node2 = new SolutionO35.Node(11);
        SolutionO35.Node node3 = new SolutionO35.Node(10);
        SolutionO35.Node node4 = new SolutionO35.Node(1);
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
        Assertions.assertTrue(UtUtils.assertJsonEquals(head, solutionO35.copyRandomList(head)));
    }

    @Test
    public void example2() {
        SolutionO35.Node head = new SolutionO35.Node(1);
        SolutionO35.Node node1 = new SolutionO35.Node(2);
        head.next = node1;
        node1.next = null;
        head.random = node1;
        node1.random = node1;
        Assertions.assertTrue(UtUtils.assertJsonEquals(head, solutionO35.copyRandomList(head)));
    }

    @Test
    public void example3() {
        SolutionO35.Node head = new SolutionO35.Node(3);
        SolutionO35.Node node1 = new SolutionO35.Node(3);
        SolutionO35.Node node2 = new SolutionO35.Node(3);
        head.next = node1;
        node1.next = node2;
        node2.next = null;
        head.random = null;
        node1.random = head;
        node2.random = null;
        Assertions.assertTrue(UtUtils.assertJsonEquals(head, solutionO35.copyRandomList(head)));
    }

    @Test
    public void example4() {
        SolutionO35.Node head = null;
        Assertions.assertTrue(UtUtils.assertJsonEquals(head, solutionO35.copyRandomList(head)));
    }
}
