import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4098Tests {
    private final Solution4098 solution4098 = new Solution4098();

    @Test
    public void example1() {
        int n = 4;
        int index = 2;
        int value = 8;
        long expected = 10;
        Assertions.assertEquals(expected, solution4098.minimumMaxValue(n, index, value));
    }

    @Test
    public void example2() {
        int n = 2;
        int index = 1;
        int value = 3;
        long expected = -1;
        Assertions.assertEquals(expected, solution4098.minimumMaxValue(n, index, value));
    }

    @Test
    public void example3() {
        int n = 2;
        int index = 0;
        int value = 3;
        long expected = 6;
        Assertions.assertEquals(expected, solution4098.minimumMaxValue(n, index, value));
    }
}
