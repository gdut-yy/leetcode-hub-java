import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3449Tests {
    private final Solution3449 solution3449 = new Solution3449();

    @Test
    public void example1() {
        int[] points = {2, 4};
        int m = 3;
        long expected = 4;
        Assertions.assertEquals(expected, solution3449.maxScore(points, m));
    }

    @Test
    public void example2() {
        int[] points = {1, 2, 3};
        int m = 5;
        long expected = 2;
        Assertions.assertEquals(expected, solution3449.maxScore(points, m));
    }
}