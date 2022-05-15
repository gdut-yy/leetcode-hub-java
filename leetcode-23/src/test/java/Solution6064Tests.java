import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6064Tests {
    private final Solution6064 solution6064 = new Solution6064();

    @Test
    public void example1() {
        int bottom = 2;
        int top = 9;
        int[] special = {4, 6};
        int expected = 3;
        Assertions.assertEquals(expected, solution6064.maxConsecutive(bottom, top, special));
    }

    @Test
    public void example2() {
        int bottom = 6;
        int top = 8;
        int[] special = {7, 6, 8};
        int expected = 0;
        Assertions.assertEquals(expected, solution6064.maxConsecutive(bottom, top, special));
    }
}
