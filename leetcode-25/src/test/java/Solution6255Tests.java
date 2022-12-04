import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6255Tests {
    private final Solution6255 solution6255 = new Solution6255();

    @Test
    public void example1() {
        int n = 4;
        int[][] roads = UtUtils.stringToInts2("[[1,2,9],[2,3,6],[2,4,5],[1,4,7]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution6255.minScore(n, roads));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] roads = UtUtils.stringToInts2("[[1,2,2],[1,3,4],[3,4,7]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution6255.minScore(n, roads));
    }
}
