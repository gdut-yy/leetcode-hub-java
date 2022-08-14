import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6050Tests {
    private final Solution6050 solution6050 = new Solution6050();

    @Test
    public void example1() {
        String pattern = "IIIDIDDD";
        String expected = "123549876";
        Assertions.assertEquals(expected, solution6050.smallestNumber(pattern));
    }

    @Test
    public void example2() {
        String pattern = "DDD";
        String expected = "4321";
        Assertions.assertEquals(expected, solution6050.smallestNumber(pattern));
    }
}
