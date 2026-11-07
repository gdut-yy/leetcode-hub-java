import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4071Tests {
    private final Solution4071 solution4071 = new Solution4071();

    @Test
    public void example1() {
        int n = 4;
        String s = "1502";
        int expected = 9;
        Assertions.assertEquals(expected, solution4071.minRotations(n, s));
    }

    @Test
    public void example2() {
        int n = 4;
        String s = "2916";
        int expected = 12;
        Assertions.assertEquals(expected, solution4071.minRotations(n, s));
    }

    @Test
    public void example3() {
        int n = 4;
        String s = "4219";
        int expected = 6;
        Assertions.assertEquals(expected, solution4071.minRotations(n, s));
    }
}
