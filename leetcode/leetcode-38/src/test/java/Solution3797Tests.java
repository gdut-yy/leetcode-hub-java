import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3797Tests {
    private final Solution3797 solution3797 = new Solution3797();

    @Test
    public void example1() {
        String[] grid = {"..", "#."};
        int d = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution3797.numberOfRoutes(grid, d));
    }

    @Test
    public void example2() {
        String[] grid = {"..", "#."};
        int d = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution3797.numberOfRoutes(grid, d));
    }

    @Test
    public void example3() {
        String[] grid = {"#"};
        int d = 750;
        int expected = 0;
        Assertions.assertEquals(expected, solution3797.numberOfRoutes(grid, d));
    }

    @Test
    public void example4() {
        String[] grid = {".."};
        int d = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution3797.numberOfRoutes(grid, d));
    }
}