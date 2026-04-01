import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3864Tests {
    private final Solution3864 solution3864 = new Solution3864();

    @Test
    public void example1() {
        String s = "1010";
        int encCost = 2;
        int flatCost = 1;
        long expected = 6;
        Assertions.assertEquals(expected, solution3864.minCost(s, encCost, flatCost));
    }

    @Test
    public void example2() {
        String s = "1010";
        int encCost = 3;
        int flatCost = 10;
        long expected = 12;
        Assertions.assertEquals(expected, solution3864.minCost(s, encCost, flatCost));
    }

    @Test
    public void example3() {
        String s = "00";
        int encCost = 1;
        int flatCost = 2;
        long expected = 2;
        Assertions.assertEquals(expected, solution3864.minCost(s, encCost, flatCost));
    }
}