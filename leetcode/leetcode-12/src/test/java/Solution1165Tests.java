import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1165Tests {
    private final Solution1165 solution1165 = new Solution1165();

    @Test
    public void example1() {
        String keyboard = "abcdefghijklmnopqrstuvwxyz";
        String word = "cba";
        int expected = 4;
        Assertions.assertEquals(expected, solution1165.calculateTime(keyboard, word));
    }

    @Test
    public void example2() {
        String keyboard = "pqrstuvwxyzabcdefghijklmno";
        String word = "leetcode";
        int expected = 73;
        Assertions.assertEquals(expected, solution1165.calculateTime(keyboard, word));
    }
}