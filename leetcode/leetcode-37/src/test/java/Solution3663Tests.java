import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3663Tests {
    private final Solution3663 solution3663 = new Solution3663();

    @Test
    public void example1() {
        int n = 1553322;
        int expected = 1;
        Assertions.assertEquals(expected, solution3663.getLeastFrequentDigit(n));
    }

    @Test
    public void example2() {
        int n = 723344511;
        int expected = 2;
        Assertions.assertEquals(expected, solution3663.getLeastFrequentDigit(n));
    }
}