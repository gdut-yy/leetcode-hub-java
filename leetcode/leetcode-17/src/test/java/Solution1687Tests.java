import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1687Tests {
    private final Solution1687 solution1687 = new Solution1687();

    @Test
    public void example1() {
        int[][] boxes = UtUtils.stringToInts2("[[1,1],[2,1],[1,1]]");
        int portsCount = 2;
        int maxBoxes = 3;
        int maxWeight = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution1687.boxDelivering(boxes, portsCount, maxBoxes, maxWeight));
    }

    @Test
    public void example2() {
        int[][] boxes = UtUtils.stringToInts2("[[1,2],[3,3],[3,1],[3,1],[2,4]]");
        int portsCount = 3;
        int maxBoxes = 3;
        int maxWeight = 6;
        int expected = 6;
        Assertions.assertEquals(expected, solution1687.boxDelivering(boxes, portsCount, maxBoxes, maxWeight));
    }

    @Test
    public void example3() {
        int[][] boxes = UtUtils.stringToInts2("[[1,4],[1,2],[2,1],[2,1],[3,2],[3,4]]");
        int portsCount = 3;
        int maxBoxes = 6;
        int maxWeight = 7;
        int expected = 6;
        Assertions.assertEquals(expected, solution1687.boxDelivering(boxes, portsCount, maxBoxes, maxWeight));
    }

    @Test
    public void example4() {
        int[][] boxes = UtUtils.stringToInts2("[[2,4],[2,5],[3,1],[3,2],[3,7],[3,1],[4,4],[1,3],[5,2]]");
        int portsCount = 5;
        int maxBoxes = 5;
        int maxWeight = 7;
        int expected = 14;
        Assertions.assertEquals(expected, solution1687.boxDelivering(boxes, portsCount, maxBoxes, maxWeight));
    }
}