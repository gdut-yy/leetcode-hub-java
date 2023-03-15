import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution533Tests {
    private final Solution533 solution533 = new Solution533();

    @Test
    public void example1() {
        char[][] picture = UtUtils.stringToChars2("""
                [["W","B","W","B","B","W"],["W","B","W","B","B","W"],["W","B","W","B","B","W"],["W","W","B","W","B","W"]]
                """);
        int target = 3;
        int expected = 6;
        Assertions.assertEquals(expected, solution533.findBlackPixel(picture, target));
    }

    @Test
    public void example2() {
        char[][] picture = UtUtils.stringToChars2("""
                [["W","W","B"],["W","W","B"],["W","W","B"]]
                """);
        int target = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution533.findBlackPixel(picture, target));
    }
}