import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3597Tests {
    private final Solution3597 solution3597 = new Solution3597();

    @Test
    public void example1() {
        String s = "abbccccd";
        List<String> expected = List.of("a", "b", "bc", "c", "cc", "d");
        Assertions.assertEquals(expected, solution3597.partitionString(s));
    }

    @Test
    public void example2() {
        String s = "aaaa";
        List<String> expected = List.of("a", "aa");
        Assertions.assertEquals(expected, solution3597.partitionString(s));
    }
}