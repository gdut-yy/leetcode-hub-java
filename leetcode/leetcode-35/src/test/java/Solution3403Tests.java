import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3403Tests {
    private final Solution3403 solution3403 = new Solution3403();

    @Test
    public void example1() {
        String word = "dbca";
        int numFriends = 2;
        String expected = "dbc";
        Assertions.assertEquals(expected, solution3403.answerString(word, numFriends));
    }

    @Test
    public void example2() {
        String word = "gggg";
        int numFriends = 4;
        String expected = "g";
        Assertions.assertEquals(expected, solution3403.answerString(word, numFriends));
    }
}