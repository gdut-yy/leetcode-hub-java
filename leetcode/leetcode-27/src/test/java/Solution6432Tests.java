import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6432Tests {
    private final Solution6432 solution6432 = new Solution6432();

    @Test
    public void example1() {
        int n = 6;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,2],[3,4]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution6432.countCompleteComponents(n, edges));
    }

    @Test
    public void example2() {
        int n = 6;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,2],[3,4],[3,5]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution6432.countCompleteComponents(n, edges));
    }
}