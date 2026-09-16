import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4007Tests {
    private final Solution4007 solution4007 = new Solution4007();

    @Test
    public void example1() {
        int[] planks = {1, 3, 2, 5, 7, 5, 4, 2, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution4007.maximumWidth(planks));
    }

    @Test
    public void example2() {
        int[] planks = {2, 3, 7};
        int expected = 1;
        Assertions.assertEquals(expected, solution4007.maximumWidth(planks));
    }
}