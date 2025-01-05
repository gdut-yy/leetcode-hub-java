import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3412Tests {
    private final Solution3412 solution3412 = new Solution3412();

    @Test
    public void example1() {
        String s = "aczzx";
        long expected = 5;
        Assertions.assertEquals(expected, solution3412.calculateScore(s));
    }

    @Test
    public void example2() {
        String s = "abcdef";
        long expected = 0;
        Assertions.assertEquals(expected, solution3412.calculateScore(s));
    }
}