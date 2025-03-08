import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3448Tests {
    private final Solution3448.V1 solution3448_v1 = new Solution3448.V1();
    private final Solution3448.V2 solution3448_v2 = new Solution3448.V2();
    private final Solution3448.V3 solution3448_v3 = new Solution3448.V3();

    @Test
    public void example1() {
        String s = "12936";
        long expected = 11;
        Assertions.assertEquals(expected, solution3448_v1.countSubstrings(s));
        Assertions.assertEquals(expected, solution3448_v2.countSubstrings(s));
        Assertions.assertEquals(expected, solution3448_v3.countSubstrings(s));
    }

    @Test
    public void example2() {
        String s = "5701283";
        long expected = 18;
        Assertions.assertEquals(expected, solution3448_v1.countSubstrings(s));
        Assertions.assertEquals(expected, solution3448_v2.countSubstrings(s));
        Assertions.assertEquals(expected, solution3448_v3.countSubstrings(s));
    }

    @Test
    public void example3() {
        String s = "1010101010";
        long expected = 25;
        Assertions.assertEquals(expected, solution3448_v1.countSubstrings(s));
        Assertions.assertEquals(expected, solution3448_v2.countSubstrings(s));
        Assertions.assertEquals(expected, solution3448_v3.countSubstrings(s));
    }
}