import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SolutionI1012Tests {
    private final SolutionI1012 solutionI1012 = new SolutionI1012();

    @Test
    public void example1() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("bat"),
                Arrays.asList("nat", "tan"),
                Arrays.asList("ate", "eat", "tea")
        );
        List<List<String>> actual = solutionI1012.groupAnagrams(strs);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
