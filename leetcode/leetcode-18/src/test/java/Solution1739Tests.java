import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1739Tests {
    private final Solution1739 solution1739 = new Solution1739();

    @Test
    public void example1() {
        int n = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution1739.minimumBoxes(n));
        Assertions.assertEquals(expected, solution1739.minimumBoxes2(n));
    }

    @Test
    public void example2() {
        int n = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution1739.minimumBoxes(n));
        Assertions.assertEquals(expected, solution1739.minimumBoxes2(n));
    }

    @Test
    public void example3() {
        int n = 10;
        int expected = 6;
        Assertions.assertEquals(expected, solution1739.minimumBoxes(n));
        Assertions.assertEquals(expected, solution1739.minimumBoxes2(n));
    }
}