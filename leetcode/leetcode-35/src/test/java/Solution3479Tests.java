import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3479Tests {
    private final Solution3479 solution3479 = new Solution3479();

    @Test
    public void example1() {
        int[] fruits = {4, 2, 5};
        int[] baskets = {3, 5, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solution3479.numOfUnplacedFruits(fruits, baskets));
    }

    @Test
    public void example2() {
        int[] fruits = {3, 6, 1};
        int[] baskets = {6, 4, 7};
        int expected = 0;
        Assertions.assertEquals(expected, solution3479.numOfUnplacedFruits(fruits, baskets));
    }
}