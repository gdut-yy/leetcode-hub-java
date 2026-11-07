import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4068Tests {
    private final Solution4068 solution4068 = new Solution4068();

    @Test
    public void example1() {
        int[][] meetings = UtUtils.stringToInts2("[[2,5,4],[6,8,3]]");
        long expected = 8;
        Assertions.assertEquals(expected, solution4068.maxEarnings(meetings));
    }

    @Test
    public void example2() {
        int[][] meetings = UtUtils.stringToInts2("[[3,5,4],[4,7,8],[8,10,3]]");
        long expected = 12;
        Assertions.assertEquals(expected, solution4068.maxEarnings(meetings));
    }

    @Test
    public void example3() {
        int[][] meetings = UtUtils.stringToInts2("[[1,2,2],[4,5,2],[7,9,3]]");
        long expected = 11;
        Assertions.assertEquals(expected, solution4068.maxEarnings(meetings));
    }
}
