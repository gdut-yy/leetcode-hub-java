import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1428Tests {
    private final Solution1428 solution1428 = new Solution1428();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[0,0],[1,1]]");
        Solution1428.BinaryMatrix binaryMatrix = new Solution1428.BinaryMatrixImpl(mat);
        int expected = 0;
        Assertions.assertEquals(expected, solution1428.leftMostColumnWithOne(binaryMatrix));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[0,0],[0,1]]");
        Solution1428.BinaryMatrix binaryMatrix = new Solution1428.BinaryMatrixImpl(mat);
        int expected = 1;
        Assertions.assertEquals(expected, solution1428.leftMostColumnWithOne(binaryMatrix));
    }

    @Test
    public void example3() {
        int[][] mat = UtUtils.stringToInts2("[[0,0],[0,0]]");
        Solution1428.BinaryMatrix binaryMatrix = new Solution1428.BinaryMatrixImpl(mat);
        int expected = -1;
        Assertions.assertEquals(expected, solution1428.leftMostColumnWithOne(binaryMatrix));
    }

    @Test
    public void example4() {
        int[][] mat = UtUtils.stringToInts2("[[0,0,0,1],[0,0,1,1],[0,1,1,1]]");
        Solution1428.BinaryMatrix binaryMatrix = new Solution1428.BinaryMatrixImpl(mat);
        int expected = 1;
        Assertions.assertEquals(expected, solution1428.leftMostColumnWithOne(binaryMatrix));
    }
}
