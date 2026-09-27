import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP3930Tests {
    private final SolutionP3930 solutionP3930 = new SolutionP3930();

    @Test
    public void example1() {
        int[] nums = UtUtils.stringToInts("[2]");
        int p = 4;
        int[][] queries = UtUtils.stringToInts2("[[3,1],[1,2]]");
        List<Integer> expected = List.of(64, 4096);
        Assertions.assertEquals(expected, solutionP3930.powerUpdate(nums, p, queries));
    }

    @Test
    public void example2() {
        int[] nums = UtUtils.stringToInts("[7,5]");
        int p = 6;
        int[][] queries = UtUtils.stringToInts2("[[4,3],[7,2]]");
        List<Integer> expected = List.of(1296, 220296870);
        Assertions.assertEquals(expected, solutionP3930.powerUpdate(nums, p, queries));
    }
}
