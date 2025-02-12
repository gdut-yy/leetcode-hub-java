import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3445Tests {
    private final Solution3445 solution3445 = new Solution3445();

    @Test
    public void example1() {
        String s = "12233";
        int k = 4;
        int expected = -1;
        Assertions.assertEquals(expected, solution3445.maxDifference(s, k));
    }

    @Test
    public void example2() {
        String s = "1122211";
        int k = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution3445.maxDifference(s, k));
    }

    @Test
    public void example3() {
        String s = "110";
        int k = 3;
        int expected = -1;
        Assertions.assertEquals(expected, solution3445.maxDifference(s, k));
    }
}