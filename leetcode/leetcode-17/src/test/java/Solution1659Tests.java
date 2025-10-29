import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1659Tests {
    private final Solution1659 solution1659 = new Solution1659();

    @Test
    public void example1() {
        int m = 2;
        int n = 3;
        int introvertsCount = 1;
        int extrovertsCount = 2;
        int expected = 240;
        Assertions.assertEquals(expected, solution1659.getMaxGridHappiness(m, n, introvertsCount, extrovertsCount));
    }

    @Test
    public void example2() {
        int m = 3;
        int n = 1;
        int introvertsCount = 2;
        int extrovertsCount = 1;
        int expected = 260;
        Assertions.assertEquals(expected, solution1659.getMaxGridHappiness(m, n, introvertsCount, extrovertsCount));
    }

    @Test
    public void example3() {
        int m = 2;
        int n = 2;
        int introvertsCount = 4;
        int extrovertsCount = 0;
        int expected = 240;
        Assertions.assertEquals(expected, solution1659.getMaxGridHappiness(m, n, introvertsCount, extrovertsCount));
    }
}