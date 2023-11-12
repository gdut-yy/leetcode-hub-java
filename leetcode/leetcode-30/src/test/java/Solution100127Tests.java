import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100127Tests {
    private final Solution100127 solution100127 = new Solution100127();

    @Test
    public void example1() {
        int n = 5;
        int limit = 2;
        long expected = 3;
        Assertions.assertEquals(expected, solution100127.distributeCandies2(n, limit));
    }

    @Test
    public void example2() {
        int n = 3;
        int limit = 3;
        long expected = 10;
        Assertions.assertEquals(expected, solution100127.distributeCandies2(n, limit));
    }
}