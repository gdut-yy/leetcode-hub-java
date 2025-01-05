import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3413Tests {
    private final Solution3413 solution3413 = new Solution3413();

    @Test
    public void example1() {
        int[][] coins = UtUtils.stringToInts2("[[8,10,1],[1,3,2],[5,6,4]]");
        int k = 4;
        long expected = 10;
        Assertions.assertEquals(expected, solution3413.maximumCoins(coins, k));
    }

    @Test
    public void example2() {
        int[][] coins = UtUtils.stringToInts2("[[1,10,3]]");
        int k = 2;
        long expected = 6;
        Assertions.assertEquals(expected, solution3413.maximumCoins(coins, k));
    }
}