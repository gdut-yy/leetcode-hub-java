import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3474Tests {
    private final Solution3474 solution3474 = new Solution3474();

    @Test
    public void example1() {
        String str1 = "TFTF";
        String str2 = "ab";
        String expected = "ababa";
        Assertions.assertEquals(expected, solution3474.generateString(str1, str2));
    }

    @Test
    public void example2() {
        String str1 = "TFTF";
        String str2 = "abc";
        String expected = "";
        Assertions.assertEquals(expected, solution3474.generateString(str1, str2));
    }

    @Test
    public void example3() {
        String str1 = "F";
        String str2 = "d";
        String expected = "a";
        Assertions.assertEquals(expected, solution3474.generateString(str1, str2));
    }
}