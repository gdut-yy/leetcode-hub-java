import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3813Tests {
    private final Solution3813 solution3813 = new Solution3813();

    @Test
    public void example1() {
        String s = "cooear";
        int expected = 2;
        Assertions.assertEquals(expected, solution3813.vowelConsonantScore(s));
    }

    @Test
    public void example2() {
        String s = "axeyizou";
        int expected = 1;
        Assertions.assertEquals(expected, solution3813.vowelConsonantScore(s));
    }

    @Test
    public void example3() {
        String s = "au 123";
        int expected = 0;
        Assertions.assertEquals(expected, solution3813.vowelConsonantScore(s));
    }
}