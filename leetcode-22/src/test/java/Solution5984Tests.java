import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5984Tests {
    private final Solution5984 solution5984 = new Solution5984();

    @Test
    public void example1() {
        int num = 2932;
        int expected = 52;
        Assertions.assertEquals(expected, solution5984.minimumSum(num));
    }

    @Test
    public void example2() {
        int num = 4009;
        int expected = 13;
        Assertions.assertEquals(expected, solution5984.minimumSum(num));
    }
}
