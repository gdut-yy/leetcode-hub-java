import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution4031Tests {
    private final Solution4031 solution4031 = new Solution4031();

    @Test
    public void example1() {
        int[] nums = {3, 9, 7};
        int lower = 1;
        int upper = 12;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,2],[4,6],[8,8],[10,12]]");
        Assertions.assertEquals(expected, solution4031.findDisappearedNumbers(nums, lower, upper));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1};
        int lower = 5;
        int upper = 7;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[5,7]]");
        Assertions.assertEquals(expected, solution4031.findDisappearedNumbers(nums, lower, upper));
    }

    @Test
    public void example3() {
        int[] nums = {2, 3, 5};
        int lower = 2;
        int upper = 3;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[]");
        Assertions.assertEquals(expected, solution4031.findDisappearedNumbers(nums, lower, upper));
    }
}