import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4070Tests {
    private final Solution4070 solution4070 = new Solution4070();

    @Test
    public void example1() {
        String s = "0192837465";
        int expected = 25;
        Assertions.assertEquals(expected, solution4070.minRotations(s));
    }

    @Test
    public void example2() {
        String s = "1200210200";
        int expected = 12;
        Assertions.assertEquals(expected, solution4070.minRotations(s));
    }
}
