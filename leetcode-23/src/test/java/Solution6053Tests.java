import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6053Tests {
    private final Solution6053 solution6053 = new Solution6053();

    @Test
    public void example1() {
        int m = 4;
        int n = 6;
        int[][] guards = UtUtils.stringToInts2("[[0,0],[1,1],[2,3]]");
        int[][] walls = UtUtils.stringToInts2("[[0,1],[2,2],[1,4]]");
        int expected = 7;
        Assertions.assertEquals(expected, solution6053.countUnguarded(m, n, guards, walls));
    }

    @Test
    public void example2() {
        int m = 3;
        int n = 3;
        int[][] guards = UtUtils.stringToInts2("[[1,1]]");
        int[][] walls = UtUtils.stringToInts2("[[0,1],[1,0],[2,1],[1,2]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution6053.countUnguarded(m, n, guards, walls));
    }
}
