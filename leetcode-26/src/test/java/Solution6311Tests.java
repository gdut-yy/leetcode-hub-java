import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6311Tests {
    private final Solution6311 solution6311 = new Solution6311();

    @Test
    public void example1() {
        int n = 1;
        long expected = 1;
        Assertions.assertEquals(expected, solution6311.coloredCells(n));
    }

    @Test
    public void example2() {
        int n = 2;
        long expected = 5;
        Assertions.assertEquals(expected, solution6311.coloredCells(n));
    }
}