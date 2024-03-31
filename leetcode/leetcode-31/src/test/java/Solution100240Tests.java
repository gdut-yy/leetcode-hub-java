import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100240Tests {
    private final Solution100240 solution100240 = new Solution100240();

    @Test
    public void example1() {
        int[][] point = UtUtils.stringToInts2("[[3,10],[5,15],[10,2],[4,4]]");
        int expected = 12;
        Assertions.assertEquals(expected, solution100240.minimumDistance(point));
    }

    @Test
    public void example2() {
        int[][] point = UtUtils.stringToInts2("[[1,1],[1,1],[1,1]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution100240.minimumDistance(point));
    }
}