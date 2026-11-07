import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4085Tests {
    private final Solution4085 solution4085 = new Solution4085();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[3,1],[3,2],[1,4],[2,0]]");
        String colors = "BRRWB";
        int expected = 3;
        Assertions.assertEquals(expected, solution4085.findColoredRoot(edges, colors));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[2,3]]");
        String colors = "RBRB";
        int expected = -1;
        Assertions.assertEquals(expected, solution4085.findColoredRoot(edges, colors));
    }
}
