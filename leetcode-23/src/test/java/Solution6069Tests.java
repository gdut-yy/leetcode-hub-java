import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6069Tests {
    private final Solution6069 solution6069 = new Solution6069();

    @Test
    public void example1() {
        String s = "aababbb";
        int expected = 3;
        Assertions.assertEquals(expected, solution6069.largestVariance(s));
    }

    @Test
    public void example2() {
        String s = "abcde";
        int expected = 0;
        Assertions.assertEquals(expected, solution6069.largestVariance(s));
    }
}
