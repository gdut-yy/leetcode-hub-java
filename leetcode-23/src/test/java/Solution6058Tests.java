import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6058Tests {
    private final Solution6058 solution6058 = new Solution6058();

    @Test
    public void example1() {
        String pressedKeys = "22233";
        int expected = 8;
        Assertions.assertEquals(expected, solution6058.countTexts(pressedKeys));
    }

    @Test
    public void example2() {
        String pressedKeys = "222222222222222222222222222222222222";
        int expected = 82876089;
        Assertions.assertEquals(expected, solution6058.countTexts(pressedKeys));
    }
}
