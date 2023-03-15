import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution683Tests {
    private final Solution683 solution683 = new Solution683();

    @Test
    public void example1() {
        int[] bulbs = {1, 3, 2};
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution683.kEmptySlots(bulbs, k));
        Assertions.assertEquals(expected, solution683.kEmptySlots2(bulbs, k));
    }

    @Test
    public void example2() {
        int[] bulbs = {1, 2, 3};
        int k = 1;
        int expected = -1;
        Assertions.assertEquals(expected, solution683.kEmptySlots(bulbs, k));
        Assertions.assertEquals(expected, solution683.kEmptySlots2(bulbs, k));
    }
}