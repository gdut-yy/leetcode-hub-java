import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution186Tests {
    private final Solution186 solution186 = new Solution186();

    @Test
    public void example1() {
        char[] s = UtUtils.stringToChars("""
                ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
                """);
        char[] expected = UtUtils.stringToChars("""
                ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
                """);
        solution186.reverseWords(s);
        Assertions.assertArrayEquals(expected, s);
    }

    @Test
    public void example2() {
        char[] s = UtUtils.stringToChars("""
                ["a"]
                """);
        char[] expected = UtUtils.stringToChars("""
                ["a"]
                 """);
        solution186.reverseWords(s);
        Assertions.assertArrayEquals(expected, s);
    }
}
