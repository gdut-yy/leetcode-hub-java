import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100322Tests {
    private final Solution100322 solution100322 = new Solution100322();

    @Test
    public void example1() {
        String s = "aaba*";
        String expected = "aab";
        Assertions.assertEquals(expected, solution100322.clearStars(s));
    }

    @Test
    public void example2() {
        String s = "abc";
        String expected = "abc";
        Assertions.assertEquals(expected, solution100322.clearStars(s));
    }
}