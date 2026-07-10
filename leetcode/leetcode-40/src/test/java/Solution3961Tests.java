import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3961Tests {
    private final Solution3961 solution3961 = new Solution3961();

    @Test
    public void example1() {
        int[][] units = UtUtils.stringToInts2("[[1,3],[2,2]]");
        long expected = 4;
        Assertions.assertEquals(expected, solution3961.maxRatings(units));
    }

    @Test
    public void example2() {
        int[][] units = UtUtils.stringToInts2("[[1,2,3],[4,5,6]]");
        long expected = 6;
        Assertions.assertEquals(expected, solution3961.maxRatings(units));
    }

    @Test
    public void example3() {
        int[][] units = UtUtils.stringToInts2("[[5,5,5],[1,1,1]]");
        long expected = 6;
        Assertions.assertEquals(expected, solution3961.maxRatings(units));
    }
}