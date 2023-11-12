import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100125Tests {
    private final Solution100125 solution100125 = new Solution100125();

    @Test
    public void example1() {
        int n = 5;
        int limit = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution100125.distributeCandies(n, limit));
    }

    @Test
    public void example2() {
        int n = 3;
        int limit = 3;
        int expected = 10;
        Assertions.assertEquals(expected, solution100125.distributeCandies(n, limit));
    }
}