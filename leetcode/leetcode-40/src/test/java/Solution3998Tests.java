import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3998Tests {
    private final Solution3998 solution3998 = new Solution3998();

    @Test
    public void example1() {
        String s = "101";
        String[] strs = {"1?1", "0?1", "0?0"};
        boolean[] expected = {true, true, false};
        Assertions.assertArrayEquals(expected, solution3998.transformStr(s, strs));
    }

    @Test
    public void example2() {
        String s = "1100";
        String[] strs = {"0011", "11?1", "1?1?"};
        boolean[] expected = {true, false, true};
        Assertions.assertArrayEquals(expected, solution3998.transformStr(s, strs));
    }

    @Test
    public void example3() {
        String s = "1010";
        String[] strs = {"0011"};
        boolean[] expected = {true};
        Assertions.assertArrayEquals(expected, solution3998.transformStr(s, strs));
    }
}