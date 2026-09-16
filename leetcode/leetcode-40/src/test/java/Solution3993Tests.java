import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3993Tests {
    private final Solution3993 solution3993 = new Solution3993();

    @Test
    public void example1() {
        int n = 4;
        int s = 3;
        int m = 5;
        long expected = 12;
        Assertions.assertEquals(expected, solution3993.maximumValue(n, s, m));
    }

    @Test
    public void example2() {
        int n = 2;
        int s = 4;
        int m = 3;
        long expected = 7;
        Assertions.assertEquals(expected, solution3993.maximumValue(n, s, m));
    }
}