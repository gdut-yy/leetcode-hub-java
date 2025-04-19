import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3516Tests {
    private final Solution3516 solution3516 = new Solution3516();

    @Test
    public void example1() {
        int x = 2;
        int y = 7;
        int z = 4;
        int expected = 1;
        Assertions.assertEquals(expected, solution3516.findClosest(x, y, z));
    }

    @Test
    public void example2() {
        int x = 2;
        int y = 5;
        int z = 6;
        int expected = 2;
        Assertions.assertEquals(expected, solution3516.findClosest(x, y, z));
    }

    @Test
    public void example3() {
        int x = 1;
        int y = 5;
        int z = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution3516.findClosest(x, y, z));
    }
}