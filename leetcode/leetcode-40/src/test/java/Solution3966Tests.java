import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3966Tests {
    private final Solution3966 solution3966 = new Solution3966();

    @Test
    public void example1() {
        long l = 10;
        long r = 15;
        int k = 1;
        long expected = 3;
        Assertions.assertEquals(expected, solution3966.goodIntegers(l, r, k));
    }

    @Test
    public void example2() {
        long l = 201;
        long r = 204;
        int k = 2;
        long expected = 2;
        Assertions.assertEquals(expected, solution3966.goodIntegers(l, r, k));
    }
}