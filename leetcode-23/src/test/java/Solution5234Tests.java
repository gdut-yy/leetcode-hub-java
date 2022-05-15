import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution5234Tests {
    private final Solution5234 solution5234 = new Solution5234();

    @Test
    public void example1() {
        String[] words = {"abba", "baba", "bbaa", "cd", "cd"};
        List<String> expected = List.of("abba", "cd");
        Assertions.assertEquals(expected, solution5234.removeAnagrams(words));
    }

    @Test
    public void example2() {
        String[] words = {"a", "b", "c", "d", "e"};
        List<String> expected = List.of("a", "b", "c", "d", "e");
        Assertions.assertEquals(expected, solution5234.removeAnagrams(words));
    }
}
