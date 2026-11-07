import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4073Tests {
    private final Solution4073 solution4073 = new Solution4073();

    @Test
    public void example1() {
        long n = 4;
        int expected = 6;
        Assertions.assertEquals(expected, solution4073.countGoodStrings(n));
    }

    @Test
    public void example2() {
        long n = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution4073.countGoodStrings(n));
    }

    @Test
    public void example3() {
        long n = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution4073.countGoodStrings(n));
    }
}
