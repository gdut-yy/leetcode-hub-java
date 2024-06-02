import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100307Tests {
    private final Solution100307 solution100307 = new Solution100307();

    @Test
    public void example1() {
        String s = "EEEEEEE";
        int expected = 7;
        Assertions.assertEquals(expected, solution100307.minimumChairs(s));
    }

    @Test
    public void example2() {
        String s = "ELELEEL";
        int expected = 2;
        Assertions.assertEquals(expected, solution100307.minimumChairs(s));
    }

    @Test
    public void example3() {
        String s = "ELEELEELLL";
        int expected = 3;
        Assertions.assertEquals(expected, solution100307.minimumChairs(s));
    }
}