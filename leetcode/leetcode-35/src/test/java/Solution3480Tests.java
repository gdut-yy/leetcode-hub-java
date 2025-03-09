import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3480Tests {
    private final Solution3480 solution3480 = new Solution3480();

    @Test
    public void example1() {
        int n = 4;
        int[][] conflictingPairs = UtUtils.stringToInts2("[[2,3],[1,4]]");
        long expected = 9;
        Assertions.assertEquals(expected, solution3480.maxSubarrays(n, conflictingPairs));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] conflictingPairs = UtUtils.stringToInts2("[[1,2],[2,5],[3,5]]");
        long expected = 12;
        Assertions.assertEquals(expected, solution3480.maxSubarrays(n, conflictingPairs));
    }
}