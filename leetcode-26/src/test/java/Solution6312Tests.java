import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6312Tests {
    private final Solution6312 solution6312 = new Solution6312();

    @Test
    public void example1() {
        int num = 4325;
        int expected = 59;
        Assertions.assertEquals(expected, solution6312.splitNum(num));
    }

    @Test
    public void example2() {
        int num = 687;
        int expected = 75;
        Assertions.assertEquals(expected, solution6312.splitNum(num));
    }
}