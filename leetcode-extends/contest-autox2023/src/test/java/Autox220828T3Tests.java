import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Autox220828T3Tests {
    private final Autox220828T3 autox220828T3 = new Autox220828T3();

    @Test
    public void example1() {
        int[] days = UtUtils.stringToInts("[1,2,3,4]");
        int[][] tickets = UtUtils.stringToInts2("[[1,3],[2,5],[3,7]]");
        long expected = 10;
        Assertions.assertEquals(expected, autox220828T3.minCostToTravelOnDays(days, tickets));
    }

    @Test
    public void example2() {
        int[] days = UtUtils.stringToInts("[1,4,5]");
        int[][] tickets = UtUtils.stringToInts2("[[1,4],[5,6],[2,5]]");
        long expected = 6;
        Assertions.assertEquals(expected, autox220828T3.minCostToTravelOnDays(days, tickets));
    }
}
