import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution727Tests {
    private final Solution727 solution727 = new Solution727();

    @Test
    public void example1() {
        String s1 = "abcdebdde";
        String s2 = "bde";
        String expected = "bcde";
        Assertions.assertEquals(expected, solution727.minWindow(s1, s2));
    }
}
