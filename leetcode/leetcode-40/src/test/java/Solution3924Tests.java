import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3924Tests {
    private final Solution3924 solution3924 = new Solution3924();

    @Test
    public void example1() {
        int n = 6;
        int[][] edge = UtUtils.stringToInts2("[[0,1,5],[1,2,3],[3,4,4],[4,5,1],[1,4,2]]");
        int source = 0;
        int target = 3;
        int k = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution3924.minimumThreshold(n, edge, source, target, k));
    }

    @Test
    public void example2() {
        int n = 6;
        int[][] edge = UtUtils.stringToInts2("[[0,1,3],[1,2,4],[3,4,5],[4,5,6]]");
        int source = 0;
        int target = 4;
        int k = 1;
        int expected = -1;
        Assertions.assertEquals(expected, solution3924.minimumThreshold(n, edge, source, target, k));
    }

    @Test
    public void example3() {
        int n = 4;
        int[][] edge = UtUtils.stringToInts2("[[0,1,2],[1,2,2],[2,3,2],[3,0,2]]");
        int source = 0;
        int target = 0;
        int k = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution3924.minimumThreshold(n, edge, source, target, k));
    }
}