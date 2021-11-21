import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5930Tests {
    private final Solution5930 solution5930 = new Solution5930();

    @Test
    public void example1() {
        int[] colors = {1, 1, 1, 6, 1, 1, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution5930.maxDistance(colors));
    }

    @Test
    public void example2() {
        int[] colors = {1, 8, 3, 8, 3};
        int expected = 4;
        Assertions.assertEquals(expected, solution5930.maxDistance(colors));
    }

    @Test
    public void example3() {
        int[] colors = {0, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution5930.maxDistance(colors));
    }
}
