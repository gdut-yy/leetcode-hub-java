import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4091Tests {
    private final Solution4091 solution4091 = new Solution4091();

    @Test
    public void example1() {
        String s = "aba";
        long expected = 2;
        Assertions.assertEquals(expected, solution4091.countMagicalPairs(s));
    }

    @Test
    public void example2() {
        String s = "kkk";
        long expected = 4;
        Assertions.assertEquals(expected, solution4091.countMagicalPairs(s));
    }

    @Test
    public void example3() {
        String s = "abcac";
        long expected = 7;
        Assertions.assertEquals(expected, solution4091.countMagicalPairs(s));
    }
}
