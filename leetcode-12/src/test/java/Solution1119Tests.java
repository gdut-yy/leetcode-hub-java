import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1119Tests {
    private final Solution1119 solution1119 = new Solution1119();

    @Test
    public void example1() {
        String s = "leetcodeisacommunityforcoders";
        String expected = "ltcdscmmntyfrcdrs";
        Assertions.assertEquals(expected, solution1119.removeVowels(s));
    }

    @Test
    public void example2() {
        String s = "aeiou";
        String expected = "";
        Assertions.assertEquals(expected, solution1119.removeVowels(s));
    }
}
