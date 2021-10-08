import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution49Tests {
    private final Solution49 solution49 = new Solution49();

    @Test
    public void example1() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("bat"),
                Arrays.asList("nat", "tan"),
                Arrays.asList("ate", "eat", "tea")
        );
        List<List<String>> actual = solution49.groupAnagrams(strs);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String[] strs = {""};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("")
        );
        List<List<String>> actual = solution49.groupAnagrams(strs);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        String[] strs = {"a"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("a")
        );
        List<List<String>> actual = solution49.groupAnagrams(strs);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
