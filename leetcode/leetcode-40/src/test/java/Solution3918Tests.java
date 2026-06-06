import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3918Tests {
    private final Solution3918.V1 solution3918_v1 = new Solution3918.V1();
    private final Solution3918.V2 solution3918_v2 = new Solution3918.V2();

    @Test
    public void example1() {
        int n = 13;
        int expected = 132;
        Assertions.assertEquals(expected, solution3918_v1.sumOfPrimesInRange(n));
        Assertions.assertEquals(expected, solution3918_v2.sumOfPrimesInRange(n));
    }

    @Test
    public void example2() {
        int n = 10;
        int expected = 17;
        Assertions.assertEquals(expected, solution3918_v1.sumOfPrimesInRange(n));
        Assertions.assertEquals(expected, solution3918_v2.sumOfPrimesInRange(n));
    }

    @Test
    public void example3() {
        int n = 8;
        int expected = 0;
        Assertions.assertEquals(expected, solution3918_v1.sumOfPrimesInRange(n));
        Assertions.assertEquals(expected, solution3918_v2.sumOfPrimesInRange(n));
    }
}