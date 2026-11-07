import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4084Tests {
    private final Solution4084 solution4084 = new Solution4084();

    @Test
    public void example1() {
        char[][] grid = UtUtils.stringToChars2("""
                [["R","D"],["U","L"]]
                """);
        int[] expected = {1, 0};
        Assertions.assertArrayEquals(expected, solution4084.lastVisitedCell(grid));
    }

    @Test
    public void example2() {
        char[][] grid = UtUtils.stringToChars2("""
                [["R","R","R"]]
                """);
        int[] expected = {0, 2};
        Assertions.assertArrayEquals(expected, solution4084.lastVisitedCell(grid));
    }
}
