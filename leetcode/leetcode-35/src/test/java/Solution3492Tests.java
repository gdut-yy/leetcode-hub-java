import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3492Tests {
    private final Solution3492 solution3492 = new Solution3492();

    @Test
    public void example1() {
        int n = 2;
        int w = 3;
        int maxWeight = 15;
        int expected = 4;
        Assertions.assertEquals(expected, solution3492.maxContainers(n, w, maxWeight));
    }

    @Test
    public void example2() {
        int n = 3;
        int w = 5;
        int maxWeight = 20;
        int expected = 4;
        Assertions.assertEquals(expected, solution3492.maxContainers(n, w, maxWeight));
    }
}