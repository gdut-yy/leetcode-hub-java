import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4102Tests {
    private final Solution4102 solution4102 = new Solution4102();

    @Test
    public void example1() {
        String s = "abac";
        long expected = 10;
        Assertions.assertEquals(expected, solution4102.countValidSubstrings(s));
    }

    @Test
    public void example2() {
        String s = "abc";
        long expected = 5;
        Assertions.assertEquals(expected, solution4102.countValidSubstrings(s));
    }

    @Test
    public void example3() {
        String s = "ac";
        long expected = 3;
        Assertions.assertEquals(expected, solution4102.countValidSubstrings(s));
    }
}
