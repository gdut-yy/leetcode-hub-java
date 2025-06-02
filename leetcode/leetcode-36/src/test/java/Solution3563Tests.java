import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3563Tests {
    private final Solution3563 solution3563 = new Solution3563();

    @Test
    public void example1() {
        String s = "abc";
        String expected = "a";
        Assertions.assertEquals(expected, solution3563.lexicographicallySmallestString(s));
    }

    @Test
    public void example2() {
        String s = "bcda";
        String expected = "";
        Assertions.assertEquals(expected, solution3563.lexicographicallySmallestString(s));
    }

    @Test
    public void example3() {
        String s = "zdce";
        String expected = "zdce";
        Assertions.assertEquals(expected, solution3563.lexicographicallySmallestString(s));
    }
}