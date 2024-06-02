import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100311Tests {
    private final Solution100311 solution100311 = new Solution100311();

    @Test
    public void example1() {
        int days = 10;
        int[][] meetings = UtUtils.stringToInts2("[[5,7],[1,3],[9,10]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution100311.countDays(days, meetings));
        Assertions.assertEquals(expected, solution100311.countDays2(days, meetings));
    }

    @Test
    public void example2() {
        int days = 5;
        int[][] meetings = UtUtils.stringToInts2("[[2,4],[1,3]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution100311.countDays(days, meetings));
        Assertions.assertEquals(expected, solution100311.countDays2(days, meetings));
    }

    @Test
    public void example3() {
        int days = 6;
        int[][] meetings = UtUtils.stringToInts2("[[1,6]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution100311.countDays(days, meetings));
        Assertions.assertEquals(expected, solution100311.countDays2(days, meetings));
    }
}