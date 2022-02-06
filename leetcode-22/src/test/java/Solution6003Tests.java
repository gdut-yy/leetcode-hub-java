import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6003Tests {
    private final Solution6003 solution6003 = new Solution6003();

    @Test
    public void example1() {
        String s = "1100101";
        int expected = 5;
        Assertions.assertEquals(expected, solution6003.minimumTime(s));
    }

    @Test
    public void example2() {
        String s = "0010";
        int expected = 2;
        Assertions.assertEquals(expected, solution6003.minimumTime(s));
    }
}
