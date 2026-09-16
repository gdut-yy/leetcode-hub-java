import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4015Tests {
    private final Solution4015 solution4015 = new Solution4015();

    @Test
    public void example1() {
        int[] parent = {-1, 0, 0, 0, 2, 2};
        int[] nums = {5, 2, 3, 1, 4, 6};
        long expected = 37;
        Assertions.assertEquals(expected, solution4015.weightedSum(parent, nums));
    }

    @Test
    public void example2() {
        int[] parent = {-1, 0, 1, 2};
        int[] nums = {1, 2, 3, 4};
        long expected = 20;
        Assertions.assertEquals(expected, solution4015.weightedSum(parent, nums));
    }
}