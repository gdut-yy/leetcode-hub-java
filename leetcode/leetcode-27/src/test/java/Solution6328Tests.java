import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6328Tests {
    private final Solution6328 solution6328 = new Solution6328();

    @Test
    public void example1() {
        String s = "adaa";
        String chars = "d";
        int[] vals = {-1000};
        int expected = 2;
        Assertions.assertEquals(expected, solution6328.maximumCostSubstring(s, chars, vals));
    }

    @Test
    public void example2() {
        String s = "abc";
        String chars = "abc";
        int[] vals = {-1, -1, -1};
        int expected = 0;
        Assertions.assertEquals(expected, solution6328.maximumCostSubstring(s, chars, vals));
    }
}