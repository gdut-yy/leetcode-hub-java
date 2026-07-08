import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3945Tests {
    private final Solution3945 solution3945 = new Solution3945();

    @Test
    public void example1() {
        int n = 122;
        int expected = 5;
        Assertions.assertEquals(expected, solution3945.digitFrequencyScore(n));
    }

    @Test
    public void example2() {
        int n = 101;
        int expected = 2;
        Assertions.assertEquals(expected, solution3945.digitFrequencyScore(n));
    }
}