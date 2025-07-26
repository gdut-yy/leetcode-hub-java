import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution818Tests {
    private final Solution818.V1 solution818_v1 = new Solution818.V1();
    private final Solution818.V2 solution818_v2 = new Solution818.V2();

    @Test
    public void example1() {
        int target = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution818_v1.racecar(target));
        Assertions.assertEquals(expected, solution818_v2.racecar(target));
    }

    @Test
    public void example2() {
        int target = 6;
        int expected = 5;
        Assertions.assertEquals(expected, solution818_v1.racecar(target));
        Assertions.assertEquals(expected, solution818_v2.racecar(target));
    }
}