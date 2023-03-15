import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution465Tests {
    private final Solution465 solution465 = new Solution465();

    @Test
    public void example1() {
        int[][] transactions = UtUtils.stringToInts2("[[0,1,10], [2,0,5]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution465.minTransfers(transactions));
    }

    @Test
    public void example2() {
        int[][] transactions = UtUtils.stringToInts2("[[0,1,10], [1,0,1], [1,2,5], [2,0,5]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution465.minTransfers(transactions));
    }
}
