import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1711Tests {
    private final Solution1711 solution1711 = new Solution1711();

    @Test
    public void example1() {
        int[] deliciousness = {1, 3, 5, 7, 9};
        int expected = 4;
        Assertions.assertEquals(expected, solution1711.countPairs(deliciousness));
    }

    @Test
    public void example2() {
        int[] deliciousness = {1, 1, 1, 3, 3, 3, 7};
        int expected = 15;
        Assertions.assertEquals(expected, solution1711.countPairs(deliciousness));
    }
}