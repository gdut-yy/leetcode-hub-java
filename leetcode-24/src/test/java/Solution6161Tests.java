import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6161Tests {
    private final Solution6161 solution6161 = new Solution6161();

    @Test
    public void example1() {
        String s = "leet**cod*e";
        String expected = "lecoe";
        Assertions.assertEquals(expected, solution6161.removeStars(s));
    }

    @Test
    public void example2() {
        String s = "erase*****";
        String expected = "";
        Assertions.assertEquals(expected, solution6161.removeStars(s));
    }
}
