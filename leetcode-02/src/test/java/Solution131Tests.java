import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution131Tests {
    private final Solution131 solution131 = new Solution131();

    @Test
    public void example1() {
        String s = "aab";
        List<List<String>> expected = List.of(List.of("a", "a", "b"), List.of("aa", "b"));
        Assertions.assertEquals(expected, solution131.partition131(s));
    }

    @Test
    public void example2() {
        String s = "a";
        List<List<String>> expected = List.of(List.of("a"));
        Assertions.assertEquals(expected, solution131.partition131(s));
    }
}
