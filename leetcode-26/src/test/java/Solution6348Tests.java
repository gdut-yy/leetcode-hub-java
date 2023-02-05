import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6348Tests {
    private final Solution6348 solution6348 = new Solution6348();

    @Test
    public void example1() {
        int[] gifts = {25, 64, 9, 4, 100};
        int k = 4;
        long expected = 29;
        Assertions.assertEquals(expected, solution6348.pickGifts(gifts, k));
    }

    @Test
    public void example2() {
        int[] gifts = {1, 1, 1, 1};
        int k = 4;
        long expected = 4;
        Assertions.assertEquals(expected, solution6348.pickGifts(gifts, k));
    }
}