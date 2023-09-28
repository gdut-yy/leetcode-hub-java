import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution2866Tests {
    private final Solution2866 solution2866 = new Solution2866();

    @Test
    public void example1() {
        List<Integer> maxHeights = Arrays.asList(5, 3, 4, 1, 1);
        long expected = 13;
        Assertions.assertEquals(expected, solution2866.maximumSumOfHeights(maxHeights));
        Assertions.assertEquals(expected, solution2866.maximumSumOfHeights2(maxHeights));
    }

    @Test
    public void example2() {
        List<Integer> maxHeights = Arrays.asList(6, 5, 3, 9, 2, 7);
        long expected = 22;
        Assertions.assertEquals(expected, solution2866.maximumSumOfHeights(maxHeights));
        Assertions.assertEquals(expected, solution2866.maximumSumOfHeights2(maxHeights));
    }

    @Test
    public void example3() {
        List<Integer> maxHeights = Arrays.asList(3, 2, 5, 5, 2, 3);
        long expected = 18;
        Assertions.assertEquals(expected, solution2866.maximumSumOfHeights(maxHeights));
        Assertions.assertEquals(expected, solution2866.maximumSumOfHeights2(maxHeights));
    }
}