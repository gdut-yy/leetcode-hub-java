import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6037Tests {
    private final Solution6037 solution6037 = new Solution6037();

    @Test
    public void example1() {
        int num = 1234;
        int expected = 3412;
        Assertions.assertEquals(expected, solution6037.largestInteger(num));
    }

    @Test
    public void example2() {
        int num = 65875;
        int expected = 87655;
        Assertions.assertEquals(expected, solution6037.largestInteger(num));
    }
}
