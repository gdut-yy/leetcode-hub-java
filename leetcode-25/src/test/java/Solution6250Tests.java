import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6250Tests {
    private final Solution6250 solution6250 = new Solution6250();

    @Test
    public void example1() {
        String customers = "YYNY";
        int expected = 2;
        Assertions.assertEquals(expected, solution6250.bestClosingTime(customers));
    }

    @Test
    public void example2() {
        String customers = "NNNNN";
        int expected = 0;
        Assertions.assertEquals(expected, solution6250.bestClosingTime(customers));
    }

    @Test
    public void example3() {
        String customers = "YYYY";
        int expected = 4;
        Assertions.assertEquals(expected, solution6250.bestClosingTime(customers));
    }
}
