import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4086Tests {
    private final Solution4086 solution4086 = new Solution4086();

    @Test
    public void example1() {
        int[][] availableIntervals = UtUtils.stringToInts2("[[1,4],[1,7],[3,9],[5,10],[10,15]]");
        int[][] targetIntervals = UtUtils.stringToInts2("[[1,3],[2,5],[7,8],[10,13],[11,15],[12,13]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution4086.minSelection(availableIntervals, targetIntervals));
    }

    @Test
    public void example2() {
        int[][] availableIntervals = UtUtils.stringToInts2("[[4,6],[1,4],[2,5]]");
        int[][] targetIntervals = UtUtils.stringToInts2("[[3,4],[2,5],[6,7]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution4086.minSelection(availableIntervals, targetIntervals));
    }

    @Test
    public void example3() {
        int[][] availableIntervals = UtUtils.stringToInts2("[[1,2],[3,4]]");
        int[][] targetIntervals = UtUtils.stringToInts2("[[1,4]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution4086.minSelection(availableIntervals, targetIntervals));
    }
}
