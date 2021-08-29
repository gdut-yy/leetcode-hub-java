import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution49Tests {
    private final Solution49 solution49 = new Solution49();

    private boolean assertListListStringEquals(List<List<String>> expected, List<List<String>> actual) {
        if (expected.size() != actual.size()) {
            return false;
        }
        Map<String, List<String>> expectedMap = new HashMap<>();
        for (List<String> list : expected) {
            if (list.size() > 0) {
                String firstString = list.get(0);
                char[] chars = firstString.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                Collections.sort(list);
                expectedMap.put(key, list);
            }
        }
        for (List<String> list : actual) {
            if (list.size() > 0) {
                String firstString = list.get(0);
                char[] chars = firstString.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                Collections.sort(list);
                if (!expectedMap.containsKey(key)
                        || expectedMap.get(key).size() != list.size()
                        || !expectedMap.get(key).equals(list)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void example1() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("bat"),
                Arrays.asList("nat", "tan"),
                Arrays.asList("ate", "eat", "tea")
        );
        Assertions.assertTrue(assertListListStringEquals(expected, solution49.groupAnagrams(strs)));
    }

    @Test
    public void example2() {
        String[] strs = {""};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("")
        );
        Assertions.assertTrue(assertListListStringEquals(expected, solution49.groupAnagrams(strs)));
    }

    @Test
    public void example3() {
        String[] strs = {"a"};
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("a")
        );
        Assertions.assertTrue(assertListListStringEquals(expected, solution49.groupAnagrams(strs)));
    }
}
