import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3418Tests {
    private final Solution3418 solution3418 = new Solution3418();

    @Test
    public void example1() {
        int[][] coins = UtUtils.stringToInts2("[[0,1,-1],[1,-2,3],[2,-3,4]]");
        int expected = 8;
        Assertions.assertEquals(expected, solution3418.maximumAmount(coins));
    }

    @Test
    public void example2() {
        int[][] coins = UtUtils.stringToInts2("[[10,10,10],[10,10,10]]");
        int expected = 40;
        Assertions.assertEquals(expected, solution3418.maximumAmount(coins));
    }
}