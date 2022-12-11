import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6261Tests {
    private final Solution6261 solution6261 = new Solution6261();

    @Test
    public void example1() {
        String[] strs = {"alic3", "bob", "3", "4", "00000"};
        int expected = 5;
        Assertions.assertEquals(expected, solution6261.maximumValue(strs));
    }

    @Test
    public void example2() {
        String[] strs = {"1", "01", "001", "0001"};
        int expected = 1;
        Assertions.assertEquals(expected, solution6261.maximumValue(strs));
    }
}
