import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution555Tests {
    private final Solution555 solution555 = new Solution555();

    @Test
    public void example1() {
        String[] strs = {"abc", "xyz"};
        String expected = "zyxcba";
        Assertions.assertEquals(expected, solution555.splitLoopedString(strs));
    }

    @Test
    public void example2() {
        String[] strs = {"abc"};
        String expected = "cba";
        Assertions.assertEquals(expected, solution555.splitLoopedString(strs));
    }
}