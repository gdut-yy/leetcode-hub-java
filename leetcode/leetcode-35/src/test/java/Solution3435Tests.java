import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3435Tests {
    private final Solution3435 solution3435 = new Solution3435();

    @Test
    public void example1() {
        String[] words = {"ab", "ba"};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]]");
        List<List<Integer>> actual = solution3435.supersequences(words);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String[] words = {"aa", "ac"};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[2,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]]");
        Assertions.assertEquals(expected, solution3435.supersequences(words));
    }

    @Test
    public void example3() {
        String[] words = {"aa", "bb", "cc"};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]]");
        Assertions.assertEquals(expected, solution3435.supersequences(words));
    }
}