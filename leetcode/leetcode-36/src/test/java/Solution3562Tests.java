import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3562Tests {
    private final Solution3562 solution3562 = new Solution3562();

    @Test
    public void example1() {
        int n = 2;
        int[] present = {1, 2};
        int[] future = {4, 3};
        int[][] hierarchy = UtUtils.stringToInts2("[[1,2]]");
        int budget = 3;
        int expected = 5;
        Assertions.assertEquals(expected, solution3562.maxProfit(n, present, future, hierarchy, budget));
    }

    @Test
    public void example2() {
        int n = 2;
        int[] present = {3, 4};
        int[] future = {5, 8};
        int[][] hierarchy = UtUtils.stringToInts2("[[1,2]]");
        int budget = 4;
        int expected = 4;
        Assertions.assertEquals(expected, solution3562.maxProfit(n, present, future, hierarchy, budget));
    }

    @Test
    public void example3() {
        int n = 3;
        int[] present = {4, 6, 8};
        int[] future = {7, 9, 11};
        int[][] hierarchy = UtUtils.stringToInts2("[[1,2],[1,3]]");
        int budget = 10;
        int expected = 10;
        Assertions.assertEquals(expected, solution3562.maxProfit(n, present, future, hierarchy, budget));
    }
}