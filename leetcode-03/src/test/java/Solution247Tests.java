import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution247Tests {
    private final Solution247 solution247 = new Solution247();

    @Test
    public void example1() {
        int n = 2;
        List<String> expected = List.of("11", "69", "88", "96");
        Assertions.assertEquals(expected, solution247.findStrobogrammatic(n));
    }
}
