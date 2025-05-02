import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3529Tests {
    private final Solution3529 solution3529 = new Solution3529();

    @Test
    public void example1() {
        char[][] grid = UtUtils.stringToChars2("""
                [["a","a","c","c"],["b","b","b","c"],["a","a","b","a"],["c","a","a","c"],["a","a","b","a"]]
                """);
        String pattern = "abaca";
        int expected = 1;
        Assertions.assertEquals(expected, solution3529.countCells(grid, pattern));
    }

    @Test
    public void example2() {
        char[][] grid = UtUtils.stringToChars2("""
                [["c","a","a","a"],["a","a","b","a"],["b","b","a","a"],["a","a","b","a"]]
                """);
        String pattern = "aba";
        int expected = 4;
        Assertions.assertEquals(expected, solution3529.countCells(grid, pattern));
    }

    @Test
    public void example3() {
        char[][] grid = UtUtils.stringToChars2("""
                [["a"]]
                """);
        String pattern = "a";
        int expected = 1;
        Assertions.assertEquals(expected, solution3529.countCells(grid, pattern));
    }
}