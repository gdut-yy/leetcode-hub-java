import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3889Tests {
    private final Solution3889 solution3889 = new Solution3889();

    @Test
    public void example1() {
        String s = "ab1z9";
        int expected = 3;
        Assertions.assertEquals(expected, solution3889.mirrorFrequency(s));
    }

    @Test
    public void example2() {
        String s = "4m7n";
        int expected = 2;
        Assertions.assertEquals(expected, solution3889.mirrorFrequency(s));
    }

    @Test
    public void example3() {
        String s = "byby";
        int expected = 0;
        Assertions.assertEquals(expected, solution3889.mirrorFrequency(s));
    }
}