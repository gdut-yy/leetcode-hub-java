import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100256Tests {
    private final Solution100256 solution100256 = new Solution100256();

    @Test
    public void example1() {
        String s = "1?:?4";
        String expected = "11:54";
        Assertions.assertEquals(expected, solution100256.findLatestTime(s));
    }

    @Test
    public void example2() {
        String s = "0?:5?";
        String expected = "09:59";
        Assertions.assertEquals(expected, solution100256.findLatestTime(s));
    }
}