import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5960Tests {
    private final Solution5960 solution5960 = new Solution5960();

    @Test
    public void example1() {
        String title = "capiTalIze tHe titLe";
        String expected = "Capitalize The Title";
        Assertions.assertEquals(expected, solution5960.capitalizeTitle(title));
    }

    @Test
    public void example2() {
        String title = "First leTTeR of EACH Word";
        String expected = "First Letter of Each Word";
        Assertions.assertEquals(expected, solution5960.capitalizeTitle(title));
    }

    @Test
    public void example3() {
        String title = "i lOve leetcode";
        String expected = "i Love Leetcode";
        Assertions.assertEquals(expected, solution5960.capitalizeTitle(title));
    }
}
