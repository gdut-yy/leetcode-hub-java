import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6124Tests {
    private final Solution6124 solution6124 = new Solution6124();

    @Test
    public void example1() {
        String s = "abccbaacz";
        char expected = 'c';
        Assertions.assertEquals(expected, solution6124.repeatedCharacter(s));
    }

    @Test
    public void example2() {
        String s = "abcdd";
        char expected = 'd';
        Assertions.assertEquals(expected, solution6124.repeatedCharacter(s));
    }
}
