import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3812Tests {
    private final Solution3812 solution3812 = new Solution3812();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        String start = "010";
        String target = "100";
        List<Integer> expected = List.of(0);
        Assertions.assertEquals(expected, solution3812.minimumFlips(n, edges, start, target));
    }

    @Test
    public void example2() {
        int n = 7;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[2,3],[3,4],[3,5],[1,6]]");
        String start = "0011000";
        String target = "0010001";
        List<Integer> expected = List.of(1, 2, 5);
        Assertions.assertEquals(expected, solution3812.minimumFlips(n, edges, start, target));
    }

    @Test
    public void example3() {
        int n = 2;
        int[][] edges = UtUtils.stringToInts2("[[0,1]]");
        String start = "00";
        String target = "01";
        List<Integer> expected = List.of(-1);
        Assertions.assertEquals(expected, solution3812.minimumFlips(n, edges, start, target));
    }
}