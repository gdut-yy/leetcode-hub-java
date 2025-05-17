import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3547Tests {
    private final Solution3547 solution3547 = new Solution3547();
    private final Solution3547.V2 solution3547_v2 = new Solution3547.V2();

    @Test
    public void example1() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[2,3]]");
        long expected = 23;
        Assertions.assertEquals(expected, solution3547.maxScore(n, edges));
        Assertions.assertEquals(expected, solution3547_v2.maxScore(n, edges));
    }

    @Test
    public void example2() {
        int n = 6;
        int[][] edges = UtUtils.stringToInts2("[[0,3],[4,5],[2,0],[1,3],[2,4],[1,5]]");
        long expected = 82;
        Assertions.assertEquals(expected, solution3547.maxScore(n, edges));
        Assertions.assertEquals(expected, solution3547_v2.maxScore(n, edges));
    }
}