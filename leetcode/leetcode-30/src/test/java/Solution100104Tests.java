import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100104Tests {
    private final Solution100104 solution100104 = new Solution100104();

    @Test
    public void example1() {
        String s = "1001";
        int expected = 2;
        Assertions.assertEquals(expected, solution100104.minChanges(s));
    }

    @Test
    public void example2() {
        String s = "10";
        int expected = 1;
        Assertions.assertEquals(expected, solution100104.minChanges(s));
    }

    @Test
    public void example3() {
        String s = "0000";
        int expected = 0;
        Assertions.assertEquals(expected, solution100104.minChanges(s));
    }
}