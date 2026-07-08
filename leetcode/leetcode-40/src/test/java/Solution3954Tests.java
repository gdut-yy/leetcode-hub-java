import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3954Tests {
    private final Solution3954 solution3954 = new Solution3954();

    @Test
    public void example1() {
        int n = 2;
        int k = 3;
        int expected = 10;
        Assertions.assertEquals(expected, solution3954.sumOfGoodIntegers(n, k));
    }

    @Test
    public void example2() {
        int n = 5;
        int k = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution3954.sumOfGoodIntegers(n, k));
    }
}