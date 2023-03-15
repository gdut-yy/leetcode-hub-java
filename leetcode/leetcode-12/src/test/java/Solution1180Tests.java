import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1180Tests {
    private final Solution1180 solution1180 = new Solution1180();

    @Test
    public void example1() {
        String s = "aaaba";
        int expected = 8;
        Assertions.assertEquals(expected, solution1180.countLetters(s));
    }

    @Test
    public void example2() {
        String s = "aaaaaaaaaa";
        int expected = 55;
        Assertions.assertEquals(expected, solution1180.countLetters(s));
    }
}