import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3798Tests {
    private final Solution3798 solution3798 = new Solution3798();

    @Test
    public void example1() {
        String s = "1112";
        String expected = "1112";
        Assertions.assertEquals(expected, solution3798.largestEven(s));
    }

    @Test
    public void example2() {
        String s = "221";
        String expected = "22";
        Assertions.assertEquals(expected, solution3798.largestEven(s));
    }

    @Test
    public void example3() {
        String s = "1";
        String expected = "";
        Assertions.assertEquals(expected, solution3798.largestEven(s));
    }
}