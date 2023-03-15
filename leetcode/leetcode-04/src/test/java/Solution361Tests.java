import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution361Tests {
    private final Solution361 solution361 = new Solution361();

    @Test
    public void example1() {
        char[][] grid = UtUtils.stringToChars2("""
                [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
                """);
        int expected = 3;
        Assertions.assertEquals(expected, solution361.maxKilledEnemies(grid));
    }

    @Test
    public void example2() {
        char[][] grid = UtUtils.stringToChars2("""
                [["W","W","W"],["0","0","0"],["E","E","E"]]
                """);
        int expected = 1;
        Assertions.assertEquals(expected, solution361.maxKilledEnemies(grid));
    }
}
