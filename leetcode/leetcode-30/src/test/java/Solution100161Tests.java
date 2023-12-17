import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100161Tests {
    private final Solution100161 solution100161 = new Solution100161();

    @Test
    public void example1() {
        int[] nums = {1, 3, 4, 8, 7, 9, 3, 5, 1};
        int k = 2;
        int[][] expected = UtUtils.stringToInts2("[[1,1,3],[3,4,5],[7,8,9]]");
        Assertions.assertArrayEquals(expected, solution100161.divideArray(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 3, 2, 7, 3};
        int k = 3;
        int[][] expected = UtUtils.stringToInts2("[]");
        Assertions.assertArrayEquals(expected, solution100161.divideArray(nums, k));
    }
}