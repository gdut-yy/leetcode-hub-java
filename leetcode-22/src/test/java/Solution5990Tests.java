import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution5990Tests {
    private final Solution5990 solution5990 = new Solution5990();

    @Test
    public void example1() {
        int[] nums = {10, 6, 5, 8};
        List<Integer> expected = Arrays.asList(10, 8);
        List<Integer> actual = solution5990.findLonely(nums);
        Collections.sort(expected);
        Collections.sort(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 5, 3};
        List<Integer> expected = Arrays.asList(1, 5);
        List<Integer> actual = solution5990.findLonely(nums);
        Collections.sort(expected);
        Collections.sort(actual);
        Assertions.assertEquals(expected, actual);
    }
}
