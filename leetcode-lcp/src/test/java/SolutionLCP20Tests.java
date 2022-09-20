import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SolutionLCP20Tests {
    private final SolutionLCP20 solutionLCP20 = new SolutionLCP20();

    @Test
    public void example1() {
        int target = 31;
        int inc = 5;
        int dec = 3;
        int[] jump = {6};
        int[] cost = {10};
        int expected = 33;
        Assertions.assertEquals(expected, solutionLCP20.busRapidTransit(target, inc, dec, jump, cost));
    }

    @Test
    public void example2() {
        int target = 612;
        int inc = 4;
        int dec = 5;
        int[] jump = {3, 6, 8, 11, 5, 10, 4};
        int[] cost = {4, 7, 6, 3, 7, 6, 4};
        int expected = 26;
        Assertions.assertEquals(expected, solutionLCP20.busRapidTransit(target, inc, dec, jump, cost));
    }

    // 补充用例
    @Test
    @Disabled
    public void example3() {
        // https://github.com/LeetCode-Feedback/LeetCode-Feedback/issues/8825
        // https://github.com/LeetCode-Feedback/LeetCode-Feedback/issues/8909
        int target = 999999991;
        int inc = 1;
        int dec = 1;
        int[] jump = {5, 4, 3, 2};
        int[] cost = {1000000, 861353, 682606, 430676};
        int expected = 26;
        Assertions.assertEquals(expected, solutionLCP20.busRapidTransit(target, inc, dec, jump, cost));
    }
}
