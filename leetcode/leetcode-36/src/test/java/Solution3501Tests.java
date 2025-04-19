import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3501Tests {
    private final Solution3501 solution3501 = new Solution3501();

    @Test
    public void example1() {
        String s = "01";
        int[][] queries = UtUtils.stringToInts2("[[0,1]]");
        List<Integer> expected = List.of(1);
        Assertions.assertEquals(expected, solution3501.maxActiveSectionsAfterTrade(s, queries));
    }

    @Test
    public void example2() {
        String s = "0100";
        int[][] queries = UtUtils.stringToInts2("[[0,3],[0,2],[1,3],[2,3]]");
        List<Integer> expected = List.of(4, 3, 1, 1);
        Assertions.assertEquals(expected, solution3501.maxActiveSectionsAfterTrade(s, queries));
    }

    @Test
    public void example3() {
        String s = "1000100";
        int[][] queries = UtUtils.stringToInts2("[[1,5],[0,6],[0,4]]");
        List<Integer> expected = List.of(6, 7, 2);
        Assertions.assertEquals(expected, solution3501.maxActiveSectionsAfterTrade(s, queries));
    }

    @Test
    public void example4() {
        String s = "01010";
        int[][] queries = UtUtils.stringToInts2("[[0,3],[1,4],[1,3]]");
        List<Integer> expected = List.of(4, 4, 2);
        Assertions.assertEquals(expected, solution3501.maxActiveSectionsAfterTrade(s, queries));
    }
}