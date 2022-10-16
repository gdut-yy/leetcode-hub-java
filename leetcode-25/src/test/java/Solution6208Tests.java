import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6208Tests {
    private final Solution6208 solution6208 = new Solution6208();

    @Test
    public void example1() {
        String time = "?5:00";
        int expected = 2;
        Assertions.assertEquals(expected, solution6208.countTime(time));
        Assertions.assertEquals(expected, solution6208.countTime2(time));
    }

    @Test
    public void example2() {
        String time = "0?:0?";
        int expected = 100;
        Assertions.assertEquals(expected, solution6208.countTime(time));
        Assertions.assertEquals(expected, solution6208.countTime2(time));
    }

    @Test
    public void example3() {
        String time = "??:??";
        int expected = 1440;
        Assertions.assertEquals(expected, solution6208.countTime(time));
        Assertions.assertEquals(expected, solution6208.countTime2(time));
    }
}
