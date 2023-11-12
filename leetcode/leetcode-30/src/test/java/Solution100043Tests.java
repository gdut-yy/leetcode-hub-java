import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100043Tests {
    private final Solution100043 solution100043 = new Solution100043();

    @Test
    public void example1() {
        int[][] values = UtUtils.stringToInts2("[[8,5,2],[6,4,1],[9,7,3]]");
        long expected = 285;
        Assertions.assertEquals(expected, solution100043.maxSpending(values));
    }

    @Test
    public void example2() {
        int[][] values = UtUtils.stringToInts2("[[10,8,6,4,2],[9,7,5,3,2]]");
        long expected = 386;
        Assertions.assertEquals(expected, solution100043.maxSpending(values));
    }
}