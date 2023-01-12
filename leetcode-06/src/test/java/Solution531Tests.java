import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution531Tests {
    private final Solution531 solution531 = new Solution531();

    @Test
    public void example1() {
        char[][] picture = UtUtils.stringToChars2("""
                [["W","W","B"],["W","B","W"],["B","W","W"]]
                """);
        int expected = 3;
        Assertions.assertEquals(expected, solution531.findLonelyPixel(picture));
    }

    @Test
    public void example2() {
        char[][] picture = UtUtils.stringToChars2("""
                [["B","B","B"],["B","B","W"],["B","B","B"]]
                """);
        int expected = 0;
        Assertions.assertEquals(expected, solution531.findLonelyPixel(picture));
    }
}
