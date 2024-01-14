import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution100207Tests {
    private final Solution100207 solution100207 = new Solution100207();

    @Test
    public void example1() {
        String s = "isawsquirrelnearmysquirrelhouseohmy";
        String a = "my";
        String b = "squirrel";
        int k = 15;
        List<Integer> expected = List.of(16, 33);
        Assertions.assertEquals(expected, solution100207.beautifulIndices(s, a, b, k));
    }

    @Test
    public void example2() {
        String s = "abcd";
        String a = "a";
        String b = "a";
        int k = 4;
        List<Integer> expected = List.of(0);
        Assertions.assertEquals(expected, solution100207.beautifulIndices(s, a, b, k));
    }
}