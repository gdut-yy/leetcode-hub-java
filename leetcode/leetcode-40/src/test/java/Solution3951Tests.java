import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3951Tests {
    private final Solution3951 solution3951 = new Solution3951();

    @Test
    public void example1() {
        int n = 5;
        int brightness = 5;
        int[][] intervals = UtUtils.stringToInts2("[[6,12]]");
        long expected = 14;
        Assertions.assertEquals(expected, solution3951.minEnergy(n, brightness, intervals));
    }

    @Test
    public void example2() {
        int n = 2;
        int brightness = 1;
        int[][] intervals = UtUtils.stringToInts2("[[0,0],[2,2]]");
        long expected = 2;
        Assertions.assertEquals(expected, solution3951.minEnergy(n, brightness, intervals));
    }

    @Test
    public void example3() {
        int n = 4;
        int brightness = 2;
        int[][] intervals = UtUtils.stringToInts2("[[1,3],[2,4]]");
        long expected = 4;
        Assertions.assertEquals(expected, solution3951.minEnergy(n, brightness, intervals));
    }
}