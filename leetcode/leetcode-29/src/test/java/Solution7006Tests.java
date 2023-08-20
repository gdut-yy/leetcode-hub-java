import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution7006Tests {
    private final Solution7006 solution7006 = new Solution7006();

    @Test
    public void example1() {
        int n = 5;
        List<List<Integer>> offers = UtUtils.stringToIntegerList2("[[0,0,1],[0,2,2],[1,3,2]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution7006.maximizeTheProfit(n, offers));
        Assertions.assertEquals(expected, solution7006.maximizeTheProfit2(n, offers));
    }

    @Test
    public void example2() {
        int n = 5;
        List<List<Integer>> offers = UtUtils.stringToIntegerList2("[[0,0,1],[0,2,10],[1,3,2]]");
        int expected = 10;
        Assertions.assertEquals(expected, solution7006.maximizeTheProfit(n, offers));
        Assertions.assertEquals(expected, solution7006.maximizeTheProfit2(n, offers));
    }
}