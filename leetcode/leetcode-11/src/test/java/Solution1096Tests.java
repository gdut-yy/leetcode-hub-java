import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1096Tests {
    private final Solution1096 solution1096 = new Solution1096();

    @Test
    public void example1() {
        String expression = "{a,b}{c,{d,e}}";
        List<String> expected = List.of("ac", "ad", "ae", "bc", "bd", "be");
        Assertions.assertEquals(expected, solution1096.braceExpansionII(expression));
    }

    @Test
    public void example2() {
        String expression = "{{a,z},a{b,c},{ab,z}}";
        List<String> expected = List.of("a", "ab", "ac", "z");
        Assertions.assertEquals(expected, solution1096.braceExpansionII(expression));
    }
}
