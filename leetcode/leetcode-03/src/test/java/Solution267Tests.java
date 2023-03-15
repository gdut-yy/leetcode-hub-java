import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution267Tests {
    private final Solution267 solution267 = new Solution267();

    @Test
    public void example1() {
        String s = "aabb";
        List<String> expected = Arrays.asList("abba", "baab");
        List<String> actual = solution267.generatePalindromes(s);
        Collections.sort(expected);
        Collections.sort(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        String s = "abc";
        List<String> expected = Arrays.asList();
        List<String> actual = solution267.generatePalindromes(s);
        Collections.sort(expected);
        Collections.sort(actual);
        Assertions.assertEquals(expected, actual);
    }
}
