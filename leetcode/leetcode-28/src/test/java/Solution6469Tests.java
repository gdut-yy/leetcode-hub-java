import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution6469Tests {
    private final Solution6469 solution6469 = new Solution6469();

    @Test
    public void example1() {
        int[] nums = {1, 6, 7, 8};
        int[] moveFrom = {1, 7, 2};
        int[] moveTo = {2, 9, 5};
        List<Integer> expected = List.of(5, 6, 8, 9);
        Assertions.assertEquals(expected, solution6469.relocateMarbles(nums, moveFrom, moveTo));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 3, 3};
        int[] moveFrom = {1, 3};
        int[] moveTo = {2, 2};
        List<Integer> expected = List.of(2);
        Assertions.assertEquals(expected, solution6469.relocateMarbles(nums, moveFrom, moveTo));
    }
}