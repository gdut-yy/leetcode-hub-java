import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution100094Tests {
    private final Solution100094 solution100094 = new Solution100094();

    @Test
    public void example1() {
        List<Integer> nums = List.of(1, 2, 1);
        int expected = 15;
        Assertions.assertEquals(expected, solution100094.sumCounts(nums));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(2, 2);
        int expected = 3;
        Assertions.assertEquals(expected, solution100094.sumCounts(nums));
    }
}