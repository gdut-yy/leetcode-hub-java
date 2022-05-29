import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6085Tests {
    private final Solution6085 solution6085 = new Solution6085();

    @Test
    public void example1() {
        int n = 5;
        int[][] roads = UtUtils.stringToInts2("[[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]");
        long expected = 43;
        Assertions.assertEquals(expected, solution6085.maximumImportance(n, roads));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] roads = UtUtils.stringToInts2("[[0,3],[2,4],[1,3]]");
        long expected = 20;
        Assertions.assertEquals(expected, solution6085.maximumImportance(n, roads));
    }
}
