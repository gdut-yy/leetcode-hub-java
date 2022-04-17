import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6070Tests {
    private final Solution6070 solution6070 = new Solution6070();

    @Test
    public void example1() {
        String s = "11111222223";
        int k = 3;
        String expected = "135";
        Assertions.assertEquals(expected, solution6070.digitSum(s, k));
    }

    @Test
    public void example2() {
        String s = "00000000";
        int k = 3;
        String expected = "000";
        Assertions.assertEquals(expected, solution6070.digitSum(s, k));
    }
}
