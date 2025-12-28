import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3790Tests {
    private final Solution3790 solution3790 = new Solution3790();

    @Test
    public void example1() {
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution3790.minAllOneMultiple(k));
    }

    @Test
    public void example2() {
        int k = 7;
        int expected = 6;
        Assertions.assertEquals(expected, solution3790.minAllOneMultiple(k));
    }

    @Test
    public void example3() {
        int k = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solution3790.minAllOneMultiple(k));
    }
}