import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution336Tests {
    private final Solution336 solution336 = new Solution336();

    @Test
    public void example1() {
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0,1],[1,0],[3,2],[2,4]]");
        List<List<Integer>> actual = solution336.palindromePairs(words);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String[] words = {"bat", "tab", "cat"};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0,1],[1,0]]");
        List<List<Integer>> actual = solution336.palindromePairs(words);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        String[] words = {"a", ""};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0,1],[1,0]]");
        List<List<Integer>> actual = solution336.palindromePairs(words);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/392264888/
        // MLE
        String[] words = UtUtils.loadingStrings("solution336-example4-input.txt", 0);
        List<List<Integer>> expected = UtUtils.loadingIntegerList2("solution336-example4-output.txt", 0);
        List<List<Integer>> actual = solution336.palindromePairs(words);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
