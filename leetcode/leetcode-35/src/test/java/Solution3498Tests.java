import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3498Tests {
    private final Solution3498 solution3498 = new Solution3498();

    @Test
    public void example1() {
        String s = "abc";
        int expected = 148;
        Assertions.assertEquals(expected, solution3498.reverseDegree(s));
    }

    @Test
    public void example2() {
        String s = "zaza";
        int expected = 160;
        Assertions.assertEquals(expected, solution3498.reverseDegree(s));
    }
}