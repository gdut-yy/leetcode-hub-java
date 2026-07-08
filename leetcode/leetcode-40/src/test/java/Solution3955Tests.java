import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution3955Tests {
    private final Solution3955 solution3955 = new Solution3955();

    @Test
    public void example1() {
        int n = 3;
        int k = 1;
        List<String> expected = Arrays.asList("000", "010", "100");
        Assertions.assertEquals(expected, solution3955.generateValidStrings(n, k));
    }

    @Test
    public void example2() {
        int n = 1;
        int k = 0;
        List<String> expected = Arrays.asList("0", "1");
        Assertions.assertEquals(expected, solution3955.generateValidStrings(n, k));
    }
}