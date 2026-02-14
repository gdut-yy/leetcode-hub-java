import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3809Tests {
    private final Solution3809 solution3809 = new Solution3809();

    @Test
    public void example1() {
        int[][] towers = UtUtils.stringToInts2("[[1,2,5], [2,1,7], [3,1,9]]");
        int[] center = {1, 1};
        int radius = 2;
        int[] expected = {3, 1};
        Assertions.assertArrayEquals(expected, solution3809.bestTower(towers, center, radius));
    }

    @Test
    public void example2() {
        int[][] towers = UtUtils.stringToInts2("[[1,3,4], [2,2,4], [4,4,7]]");
        int[] center = {0, 0};
        int radius = 5;
        int[] expected = {1, 3};
        Assertions.assertArrayEquals(expected, solution3809.bestTower(towers, center, radius));
    }

    @Test
    public void example3() {
        int[][] towers = UtUtils.stringToInts2("[[5,6,8], [0,3,5]]");
        int[] center = {1, 2};
        int radius = 1;
        int[] expected = {-1, -1};
        Assertions.assertArrayEquals(expected, solution3809.bestTower(towers, center, radius));
    }
}