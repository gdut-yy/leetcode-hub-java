import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6078Tests {
    private final Solution6078 solution6078 = new Solution6078();

    @Test
    public void example1() {
        String s = "ilovecodingonleetcode";
        String target = "code";
        int expected = 2;
        Assertions.assertEquals(expected, solution6078.rearrangeCharacters(s, target));
    }

    @Test
    public void example2() {
        String s = "abcba";
        String target = "abc";
        int expected = 1;
        Assertions.assertEquals(expected, solution6078.rearrangeCharacters(s, target));
    }

    @Test
    public void example3() {
        String s = "abbaccaddaeea";
        String target = "aaaaa";
        int expected = 1;
        Assertions.assertEquals(expected, solution6078.rearrangeCharacters(s, target));
    }
}
