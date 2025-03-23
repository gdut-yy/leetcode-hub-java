import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3493Tests {
    private final Solution3493 solution3493 = new Solution3493();

    @Test
    public void example1() {
        int[][] properties = UtUtils.stringToInts2("[[1,2],[1,1],[3,4],[4,5],[5,6],[7,7]]");
        int k = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution3493.numberOfComponents(properties, k));
    }

    @Test
    public void example2() {
        int[][] properties = UtUtils.stringToInts2("[[1,2,3],[2,3,4],[4,3,5]]");
        int k = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution3493.numberOfComponents(properties, k));
    }

    @Test
    public void example3() {
        int[][] properties = UtUtils.stringToInts2("[[1,1],[1,1]]");
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution3493.numberOfComponents(properties, k));
    }
}