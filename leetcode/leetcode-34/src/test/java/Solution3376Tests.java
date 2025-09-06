import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution3376Tests {
    private final Solution3376.V1 solution3376_v1 = new Solution3376.V1();
    private final Solution3376.V2 solution3376_v2 = new Solution3376.V2();

    @Test
    public void example1() {
        List<Integer> strength = Arrays.asList(3, 4, 1);
        int k = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution3376_v1.findMinimumTime(strength, k));
        Assertions.assertEquals(expected, solution3376_v2.findMinimumTime(strength, k));
    }

    @Test
    public void example2() {
        List<Integer> strength = Arrays.asList(2, 5, 4);
        int k = 2;
        int expected = 5;
        Assertions.assertEquals(expected, solution3376_v1.findMinimumTime(strength, k));
        Assertions.assertEquals(expected, solution3376_v2.findMinimumTime(strength, k));
    }
}