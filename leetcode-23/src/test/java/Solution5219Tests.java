import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5219Tests {
    private final Solution5219 solution5219 = new Solution5219();

    @Test
    public void example1() {
        int[] candies = {5, 8, 6};
        long k = 3;
        int expected = 5;
        Assertions.assertEquals(expected, solution5219.maximumCandies(candies, k));
    }

    @Test
    public void example2() {
        int[] candies = {2, 5};
        long k = 11;
        int expected = 0;
        Assertions.assertEquals(expected, solution5219.maximumCandies(candies, k));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] candies = UtUtils.loadingInts("solution5219-example3-input.txt", 0);
        long k = UtUtils.loadingLong("solution5219-example3-input.txt", 1);
        int expected = 1000000;
        Assertions.assertEquals(expected, solution5219.maximumCandies(candies, k));
    }
}
