import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution311Tests {
    private final Solution311 solution311 = new Solution311();

    @Test
    public void example1() {
        int[][] mat1 = UtUtils.stringToInts2("[[1,0,0],[-1,0,3]]");
        int[][] mat2 = UtUtils.stringToInts2("[[7,0,0],[0,0,0],[0,0,1]]");
        int[][] expected = UtUtils.stringToInts2("[[7,0,0],[-7,0,3]]");
        Assertions.assertArrayEquals(expected, solution311.multiply(mat1, mat2));
    }

    @Test
    public void example2() {
        int[][] mat1 = UtUtils.stringToInts2("[[0]]");
        int[][] mat2 = UtUtils.stringToInts2("[[0]]");
        int[][] expected = UtUtils.stringToInts2("[[0]]");
        Assertions.assertArrayEquals(expected, solution311.multiply(mat1, mat2));
    }
}
