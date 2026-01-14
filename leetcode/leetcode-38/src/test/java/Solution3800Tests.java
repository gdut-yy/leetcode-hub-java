import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3800Tests {
    private final Solution3800 solution3800 = new Solution3800();

    @Test
    public void example1() {
        String s = "01000";
        String t = "10111";
        int flipCost = 10;
        int swapCost = 2;
        int crossCost = 2;
        long expected = 16;
        Assertions.assertEquals(expected, solution3800.minimumCost(s, t, flipCost, swapCost, crossCost));
    }

    @Test
    public void example2() {
        String s = "001";
        String t = "110";
        int flipCost = 2;
        int swapCost = 100;
        int crossCost = 100;
        long expected = 6;
        Assertions.assertEquals(expected, solution3800.minimumCost(s, t, flipCost, swapCost, crossCost));
    }

    @Test
    public void example3() {
        String s = "1010";
        String t = "1010";
        int flipCost = 5;
        int swapCost = 5;
        int crossCost = 5;
        long expected = 0;
        Assertions.assertEquals(expected, solution3800.minimumCost(s, t, flipCost, swapCost, crossCost));
    }
}