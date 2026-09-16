import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4003Tests {
    private final Solution4003 solution4003 = new Solution4003();

    @Test
    public void example1() {
        int m = 2;
        int n = 2;
        int[][] penalty = UtUtils.stringToInts2("[[5,3],[1,4]]");
        long expected = 8;
        Assertions.assertEquals(expected, solution4003.minCost(m, n, penalty));
    }

    @Test
    public void example2() {
        int m = 2;
        int n = 2;
        int[][] penalty = UtUtils.stringToInts2("[[0,7],[3,2]]");
        long expected = 7;
        Assertions.assertEquals(expected, solution4003.minCost(m, n, penalty));
    }

    @Test
    public void example3() {
        int m = 2;
        int n = 3;
        int[][] penalty = UtUtils.stringToInts2("[[8,0,9],[7,4,1]]");
        long expected = 12;
        Assertions.assertEquals(expected, solution4003.minCost(m, n, penalty));
    }
}