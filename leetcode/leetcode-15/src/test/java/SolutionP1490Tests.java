import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP1490Tests {
    private final SolutionP1490 solutionP1490 = new SolutionP1490();

    @Test
    public void example1() {
        SolutionP1490.Node node1 = new SolutionP1490.Node(1);
        SolutionP1490.Node node2 = new SolutionP1490.Node(2);
        SolutionP1490.Node node3 = new SolutionP1490.Node(3);
        SolutionP1490.Node node4 = new SolutionP1490.Node(4);
        SolutionP1490.Node node5 = new SolutionP1490.Node(5);
        SolutionP1490.Node node6 = new SolutionP1490.Node(6);
        node1.children = List.of(node3, node2, node4);
        node3.children = List.of(node5, node6);
        Assertions.assertTrue(UtUtils.assertJsonEquals(node1, solutionP1490.cloneTree(node1)));
    }

    @Test
    public void example2() {
        SolutionP1490.Node node1 = new SolutionP1490.Node(1);
        SolutionP1490.Node node2 = new SolutionP1490.Node(2);
        SolutionP1490.Node node3 = new SolutionP1490.Node(3);
        SolutionP1490.Node node4 = new SolutionP1490.Node(4);
        SolutionP1490.Node node5 = new SolutionP1490.Node(5);
        SolutionP1490.Node node6 = new SolutionP1490.Node(6);
        SolutionP1490.Node node7 = new SolutionP1490.Node(7);
        SolutionP1490.Node node8 = new SolutionP1490.Node(8);
        SolutionP1490.Node node9 = new SolutionP1490.Node(9);
        SolutionP1490.Node node10 = new SolutionP1490.Node(10);
        SolutionP1490.Node node11 = new SolutionP1490.Node(11);
        SolutionP1490.Node node12 = new SolutionP1490.Node(12);
        SolutionP1490.Node node13 = new SolutionP1490.Node(13);
        SolutionP1490.Node node14 = new SolutionP1490.Node(14);
        node1.children = List.of(node2, node3, node4, node5);
        node3.children = List.of(node6, node7);
        node4.children = List.of(node8);
        node5.children = List.of(node9, node10);
        node7.children = List.of(node11);
        node8.children = List.of(node12);
        node9.children = List.of(node13);
        node11.children = List.of(node14);
        Assertions.assertTrue(UtUtils.assertJsonEquals(node1, solutionP1490.cloneTree(node1)));
    }
}