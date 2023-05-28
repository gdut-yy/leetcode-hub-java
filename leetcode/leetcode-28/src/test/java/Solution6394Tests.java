import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6394Tests {
    private final Solution6394 solution6394 = new Solution6394();

    @Test
    public void example1() {
        String s = "leetscode";
        String[] dictionary = {"leet", "code", "leetcode"};
        int expected = 1;
        Assertions.assertEquals(expected, solution6394.minExtraChar(s, dictionary));
    }

    @Test
    public void example2() {
        String s = "sayhelloworld";
        String[] dictionary = {"hello", "world"};
        int expected = 3;
        Assertions.assertEquals(expected, solution6394.minExtraChar(s, dictionary));
    }
}