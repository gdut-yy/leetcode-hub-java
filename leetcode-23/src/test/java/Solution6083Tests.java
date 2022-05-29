import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6083Tests {
    private final Solution6083 solution6083 = new Solution6083();

    @Test
    public void example1() {
        String num = "1210";
        Assertions.assertTrue(solution6083.digitCount(num));
    }

    @Test
    public void example2() {
        String num = "030";
        Assertions.assertFalse(solution6083.digitCount(num));
    }
}
