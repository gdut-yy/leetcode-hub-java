import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3455Tests {
    private final Solution3455 solution3455 = new Solution3455();

    @Test
    public void example1() {
        String s = "abaacbaecebce";
        String p = "ba*c*ce";
        int expected = 8;
        Assertions.assertEquals(expected, solution3455.shortestMatchingSubstring(s, p));
    }

    @Test
    public void example2() {
        String s = "baccbaadbc";
        String p = "cc*baa*adb";
        int expected = -1;
        Assertions.assertEquals(expected, solution3455.shortestMatchingSubstring(s, p));
    }

    @Test
    public void example3() {
        String s = "a";
        String p = "**";
        int expected = 0;
        Assertions.assertEquals(expected, solution3455.shortestMatchingSubstring(s, p));
    }

    @Test
    public void example4() {
        String s = "madlogic";
        String p = "*adlogi*";
        int expected = 6;
        Assertions.assertEquals(expected, solution3455.shortestMatchingSubstring(s, p));
    }
}