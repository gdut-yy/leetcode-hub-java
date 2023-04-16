import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6375Tests {
    private final Solution6375 solution6375 = new Solution6375();

    @Test
    public void example1() {
        String word = "b";
        int expected = 2;
        Assertions.assertEquals(expected, solution6375.addMinimum(word));
        Assertions.assertEquals(expected, solution6375.addMinimum2(word));
    }

    @Test
    public void example2() {
        String word = "aaa";
        int expected = 6;
        Assertions.assertEquals(expected, solution6375.addMinimum(word));
        Assertions.assertEquals(expected, solution6375.addMinimum2(word));
    }

    @Test
    public void example3() {
        String word = "abc";
        int expected = 0;
        Assertions.assertEquals(expected, solution6375.addMinimum(word));
        Assertions.assertEquals(expected, solution6375.addMinimum2(word));
    }
}