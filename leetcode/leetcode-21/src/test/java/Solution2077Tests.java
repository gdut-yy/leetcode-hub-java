import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2077Tests {
    private final Solution2077 solution2077 = new Solution2077();

    @Test
    public void example1() {
        int n = 5;
        int[][] corridors = UtUtils.stringToInts2("[[1,2],[5,2],[4,1],[2,4],[3,1],[3,4]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution2077.numberOfPaths(n, corridors));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] corridors = UtUtils.stringToInts2("[[1,2],[3,4]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution2077.numberOfPaths(n, corridors));
    }
}