import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution294Tests {
    private final Solution294 solution294 = new Solution294();

    @Test
    public void example1() {
        String currentState = "++++";
        Assertions.assertTrue(solution294.canWin(currentState));
    }

    @Test
    public void example2() {
        String currentState = "+";
        Assertions.assertFalse(solution294.canWin(currentState));
    }
}
