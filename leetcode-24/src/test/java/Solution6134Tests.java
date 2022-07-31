import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6134Tests {
    private final Solution6134 solution6134 = new Solution6134();

    @Test
    public void example1() {
        int[] edges = {2, 2, 3, -1};
        int node1 = 0;
        int node2 = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution6134.closestMeetingNode(edges, node1, node2));
    }

    @Test
    public void example2() {
        int[] edges = {1, 2, -1};
        int node1 = 0;
        int node2 = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution6134.closestMeetingNode(edges, node1, node2));
    }
}
