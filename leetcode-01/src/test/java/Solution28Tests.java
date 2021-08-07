import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution28Tests {
    private final Solution28 solution28 = new Solution28();

    @Test
    public void example1() {
        String haystack = "hello", needle = "ll";
        int expected = 2;
        Assertions.assertEquals(expected, solution28.strStr(haystack, needle));
        Assertions.assertEquals(expected, solution28.strStr2(haystack, needle));
    }

    @Test
    public void example2() {
        String haystack = "aaaaa", needle = "bba";
        int expected = -1;
        Assertions.assertEquals(expected, solution28.strStr(haystack, needle));
        Assertions.assertEquals(expected, solution28.strStr2(haystack, needle));
    }

    @Test
    public void example3() {
        String haystack = "", needle = "";
        int expected = 0;
        Assertions.assertEquals(expected, solution28.strStr(haystack, needle));
        Assertions.assertEquals(expected, solution28.strStr2(haystack, needle));
    }
}
