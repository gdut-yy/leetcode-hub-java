import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3841Tests {
    private final Solution3841 solution3841 = new Solution3841();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        String s = "aac";
        String[] queries = {"query 0 2", "update 1 b", "query 0 2"};
        List<Boolean> expected = List.of(true, false);
        Assertions.assertEquals(expected, solution3841.palindromePath(n, edges, s, queries));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[0,3]]");
        String s = "abca";
        String[] queries = {"query 1 2", "update 0 b", "query 2 3", "update 3 a", "query 1 3"};
        List<Boolean> expected = List.of(false, false, true);
        Assertions.assertEquals(expected, solution3841.palindromePath(n, edges, s, queries));
    }
}