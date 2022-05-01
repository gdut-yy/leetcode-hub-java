import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6050Tests {
    private final Solution6050 solution6050 = new Solution6050();

    @Test
    public void example1() {
        String s = "abbca";
        long expected = 28;
        Assertions.assertEquals(expected, solution6050.appealSum(s));
    }

    @Test
    public void example2() {
        String s = "code";
        long expected = 20;
        Assertions.assertEquals(expected, solution6050.appealSum(s));
    }
}
