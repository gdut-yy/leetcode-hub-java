import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3394Tests {
    private final Solution3394 solution3394 = new Solution3394();

    @Test
    public void example1() {
        int n = 5;
        int[][] rectangles = UtUtils.stringToInts2("[[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]]");
        Assertions.assertTrue(solution3394.checkValidCuts(n, rectangles));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] rectangles = UtUtils.stringToInts2("[[0,0,1,1],[2,0,3,4],[0,2,2,3],[3,0,4,3]]");
        Assertions.assertTrue(solution3394.checkValidCuts(n, rectangles));
    }

    @Test
    public void example3() {
        int n = 4;
        int[][] rectangles = UtUtils.stringToInts2("[[0,2,2,4],[1,0,3,2],[2,2,3,4],[3,0,4,2],[3,2,4,4]]");
        Assertions.assertFalse(solution3394.checkValidCuts(n, rectangles));
    }
}