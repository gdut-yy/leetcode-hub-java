import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2158Tests {
    private final Solution2158 solution2158 = new Solution2158();

    @Test
    public void example1() {
        int[][] paint = UtUtils.stringToInts2("[[1,4],[4,7],[5,8]]");
        int[] expected = {3, 3, 1};
        Assertions.assertArrayEquals(expected, solution2158.amountPainted(paint));
    }

    @Test
    public void example2() {
        int[][] paint = UtUtils.stringToInts2("[[1,4],[5,8],[4,7]]");
        int[] expected = {3, 3, 1};
        Assertions.assertArrayEquals(expected, solution2158.amountPainted(paint));
    }

    @Test
    public void example3() {
        int[][] paint = UtUtils.stringToInts2("[[1,5],[2,4]]");
        int[] expected = {4, 0};
        Assertions.assertArrayEquals(expected, solution2158.amountPainted(paint));
    }
}