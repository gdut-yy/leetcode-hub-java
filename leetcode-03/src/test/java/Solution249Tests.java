import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution249Tests {
    private final Solution249 solution249 = new Solution249();

    @Test
    public void example1() {
        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [
                  ["abc","bcd","xyz"],
                  ["az","ba"],
                  ["acef"],
                  ["a","z"]
                ]
                """);
        List<List<String>> actual = solution249.groupStrings(strings);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
