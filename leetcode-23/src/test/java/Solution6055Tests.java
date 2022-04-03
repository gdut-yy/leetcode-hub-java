import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6055Tests {
    private final Solution6055 solution6055 = new Solution6055();

    @Test
    public void example1() {
        String current = "02:30";
        String correct = "04:35";
        int expected = 3;
        Assertions.assertEquals(expected, solution6055.convertTime(current, correct));
    }

    @Test
    public void example2() {
        String current = "11:00";
        String correct = "11:01";
        int expected = 1;
        Assertions.assertEquals(expected, solution6055.convertTime(current, correct));
    }
}
