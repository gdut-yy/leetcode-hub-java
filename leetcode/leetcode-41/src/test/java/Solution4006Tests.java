import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4006Tests {
    private final Solution4006 solution4006 = new Solution4006();

    @Test
    public void example1() {
        String s = "00101";
        int expected = 3;
        Assertions.assertEquals(expected, solution4006.countValidPrefixes(s));
    }

    @Test
    public void example2() {
        String s = "101";
        int expected = 3;
        Assertions.assertEquals(expected, solution4006.countValidPrefixes(s));
    }
}