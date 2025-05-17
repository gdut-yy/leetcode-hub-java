import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3537Tests {
    private final Solution3537 solution3537 = new Solution3537();

    @Test
    public void example1() {
        int n = 0;
        int[][] expected = UtUtils.stringToInts2("[[0]]");
        Assertions.assertArrayEquals(expected, solution3537.specialGrid(n));
    }

    @Test
    public void example2() {
        int n = 1;
        int[][] expected = UtUtils.stringToInts2("[[3,0],[2,1]]");
        Assertions.assertArrayEquals(expected, solution3537.specialGrid(n));
    }

    @Test
    public void example3() {
        int n = 2;
        int[][] expected = UtUtils.stringToInts2("[[15,12,3,0],[14,13,2,1],[11,8,7,4],[10,9,6,5]]");
        Assertions.assertArrayEquals(expected, solution3537.specialGrid(n));
    }
}