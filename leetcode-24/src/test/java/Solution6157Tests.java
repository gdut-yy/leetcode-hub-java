import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6157Tests {
    private final Solution6157 solution6157 = new Solution6157();

    @Test
    public void example1() {
        String s = "0110101";
        int expected = 4;
        Assertions.assertEquals(expected, solution6157.secondsToRemoveOccurrences(s));
    }

    @Test
    public void example2() {
        String s = "11100";
        int expected = 0;
        Assertions.assertEquals(expected, solution6157.secondsToRemoveOccurrences(s));
    }
}
