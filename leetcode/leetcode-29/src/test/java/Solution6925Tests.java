import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6925Tests {
    private final Solution6925 solution6925 = new Solution6925();

    @Test
    public void example1() {
        String s = "string";
        String expected = "rtsng";
        Assertions.assertEquals(expected, solution6925.finalString(s));
    }

    @Test
    public void example2() {
        String s = "poiinter";
        String expected = "ponter";
        Assertions.assertEquals(expected, solution6925.finalString(s));
    }
}