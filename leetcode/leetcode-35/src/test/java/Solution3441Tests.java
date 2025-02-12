import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3441Tests {
    private final Solution3441 solution3441 = new Solution3441();

    @Test
    public void example1() {
        String caption = "cdcd";
        String expected = "cccc";
        Assertions.assertEquals(expected, solution3441.minCostGoodCaption(caption));
    }

    @Test
    public void example2() {
        String caption = "aca";
        String expected = "aaa";
        Assertions.assertEquals(expected, solution3441.minCostGoodCaption(caption));
    }

    @Test
    public void example3() {
        String caption = "bc";
        String expected = "";
        Assertions.assertEquals(expected, solution3441.minCostGoodCaption(caption));
    }
}