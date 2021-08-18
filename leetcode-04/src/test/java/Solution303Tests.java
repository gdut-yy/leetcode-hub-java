import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution303Tests {
    @Test
    public void example1() {
        // init
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Solution303.NumArray numArray = new Solution303.NumArray(nums);
        // call
        int[][] calls = {{0, 2}, {2, 5}, {0, 5}};
        int[] expected = {1, -1, -3};
        for (int i = 0; i < calls.length; i++) {
            Assertions.assertEquals(expected[i], numArray.sumRange(calls[i][0], calls[i][1]));
        }
    }
}
