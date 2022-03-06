import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution6019Tests {
    private final Solution6019 solution6019 = new Solution6019();

    @Test
    public void example1() {
        int[] nums = {6, 4, 3, 2, 7, 6, 2};
        List<Integer> expected = List.of(12, 7, 6);
        Assertions.assertEquals(expected, solution6019.replaceNonCoprimes(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 1, 1, 3, 3, 3};
        List<Integer> expected = List.of(2, 1, 1, 3);
        Assertions.assertEquals(expected, solution6019.replaceNonCoprimes(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] nums = {48757};
        List<Integer> expected = List.of(48757);
        Assertions.assertEquals(expected, solution6019.replaceNonCoprimes(nums));
    }

    @Test
    public void example4() {
        int[] nums = {517, 11, 121, 517, 3, 51, 3, 1887, 5};
        List<Integer> expected = List.of(5687, 1887, 5);
        Assertions.assertEquals(expected, solution6019.replaceNonCoprimes(nums));
    }

    @Test
    public void example5() {
        int[] nums = {31, 97561, 97561, 97561, 97561, 97561, 97561, 97561, 97561};
        List<Integer> expected = List.of(31, 97561);
        Assertions.assertEquals(expected, solution6019.replaceNonCoprimes(nums));
    }

    @Test
    @Disabled
    public void example6() {
        // TLE
        int[] nums = UtUtils.loadingInts("solution6019-example6-input.txt", 0);
        List<Integer> expected = UtUtils.loadingIntegerList("solution6019-example6-output.txt", 0);
        Assertions.assertEquals(expected, solution6019.replaceNonCoprimes(nums));
    }
}
