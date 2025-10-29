import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3722Tests {
    private final Solution3722 solution3722 = new Solution3722();

    @Test
    public void example1() {
        String s = "dcab";
        String expected = "acdb";
        Assertions.assertEquals(expected, solution3722.lexSmallest(s));
    }

    @Test
    public void example2() {
        String s = "abba";
        String expected = "aabb";
        Assertions.assertEquals(expected, solution3722.lexSmallest(s));
    }

    @Test
    public void example3() {
        String s = "zxy";
        String expected = "xzy";
        Assertions.assertEquals(expected, solution3722.lexSmallest(s));
    }
}