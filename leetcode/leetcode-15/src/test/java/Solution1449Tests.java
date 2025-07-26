import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1449Tests {
    private final Solution1449 solution1449 = new Solution1449();

    @Test
    public void example1() {
        int[] cost = {4, 3, 2, 5, 6, 7, 2, 5, 5};
        int target = 9;
        String expected = "7772";
        Assertions.assertEquals(expected, solution1449.largestNumber(cost, target));
    }

    @Test
    public void example2() {
        int[] cost = {7, 6, 5, 5, 5, 6, 8, 7, 8};
        int target = 12;
        String expected = "85";
        Assertions.assertEquals(expected, solution1449.largestNumber(cost, target));
    }

    @Test
    public void example3() {
        int[] cost = {2, 4, 6, 2, 4, 6, 4, 4, 4};
        int target = 5;
        String expected = "0";
        Assertions.assertEquals(expected, solution1449.largestNumber(cost, target));
    }

    @Test
    public void example4() {
        int[] cost = {6, 10, 15, 40, 40, 40, 40, 40, 40};
        int target = 47;
        String expected = "32211";
        Assertions.assertEquals(expected, solution1449.largestNumber(cost, target));
    }
}