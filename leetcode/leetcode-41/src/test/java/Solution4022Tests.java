import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4022Tests {
    private final Solution4022 solution4022 = new Solution4022();

    @Test
    public void example1() {
        long k = 4;
        int expected = 4;
        Assertions.assertEquals(expected, solution4022.kthDigit(k));
    }

    @Test
    public void example2() {
        long k = 15;
        int expected = 7;
        Assertions.assertEquals(expected, solution4022.kthDigit(k));
    }

    @Test
    public void example3() {
        long k = 11;
        int expected = 9;
        Assertions.assertEquals(expected, solution4022.kthDigit(k));
    }
}