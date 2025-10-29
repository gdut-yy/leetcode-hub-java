import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3723Tests {
    private final Solution3723 solution3723 = new Solution3723();

    @Test
    public void example1() {
        int num = 2;
        int sum = 3;
        String expected = "30";
        Assertions.assertEquals(expected, solution3723.maxSumOfSquares(num, sum));
    }

    @Test
    public void example2() {
        int num = 2;
        int sum = 17;
        String expected = "98";
        Assertions.assertEquals(expected, solution3723.maxSumOfSquares(num, sum));
    }

    @Test
    public void example3() {
        int num = 1;
        int sum = 10;
        String expected = "";
        Assertions.assertEquals(expected, solution3723.maxSumOfSquares(num, sum));
    }
}