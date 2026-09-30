import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution757Tests {
    private final Solution757 solution757 = new Solution757();

    @Test
    public void example1() {
        int[][] intervals = UtUtils.stringToInts2("[[1,3],[3,7],[8,9]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution757.intersectionSizeTwo(intervals));
    }

    @Test
    public void example2() {
        int[][] intervals = UtUtils.stringToInts2("[[1,3],[1,4],[2,5],[3,5]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution757.intersectionSizeTwo(intervals));
    }

    @Test
    public void example3() {
        int[][] intervals = UtUtils.stringToInts2("[[1,2],[2,3],[2,4],[4,5]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution757.intersectionSizeTwo(intervals));
    }
}
