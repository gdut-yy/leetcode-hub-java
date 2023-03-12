import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6315Tests {
    private final Solution6315 solution6315 = new Solution6315();

    @Test
    public void example1() {
        String[] words = {"are", "amy", "u"};
        int left = 0;
        int right = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution6315.vowelStrings(words, left, right));
    }

    @Test
    public void example2() {
        String[] words = {"hey", "aeo", "mu", "ooo", "artro"};
        int left = 1;
        int right = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution6315.vowelStrings(words, left, right));
    }
}