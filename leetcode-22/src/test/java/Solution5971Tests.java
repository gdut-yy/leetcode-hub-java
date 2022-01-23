import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5971Tests {
    private final Solution5971 solution5971 = new Solution5971();

    @Test
    public void example1() {
        int[] cost = {1, 2, 3};
        int expected = 5;
        Assertions.assertEquals(expected, solution5971.minimumCost(cost));
    }

    @Test
    public void example2() {
        int[] cost = {6, 5, 7, 9, 2, 2};
        int expected = 23;
        Assertions.assertEquals(expected, solution5971.minimumCost(cost));
    }

    @Test
    public void example3() {
        int[] cost = {5, 5};
        int expected = 10;
        Assertions.assertEquals(expected, solution5971.minimumCost(cost));
    }
}
