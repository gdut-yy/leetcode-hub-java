import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6219Tests {
    private final Solution6219 solution6219 = new Solution6219();

    @Test
    public void example1() {
        int num = 443;
        Assertions.assertTrue(solution6219.sumOfNumberAndReverse(num));
    }

    @Test
    public void example2() {
        int num = 63;
        Assertions.assertFalse(solution6219.sumOfNumberAndReverse(num));
    }

    @Test
    public void example3() {
        int num = 181;
        Assertions.assertTrue(solution6219.sumOfNumberAndReverse(num));
    }
}
