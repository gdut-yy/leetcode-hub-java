import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6329Tests {
    private final Solution6329 solution6329 = new Solution6329();

    @Test
    public void example1() {
        int[] arr = {1, 4, 1, 3};
        int k = 2;
        long expected = 1;
        Assertions.assertEquals(expected, solution6329.makeSubKSumEqual(arr, k));
    }

    @Test
    public void example2() {
        int[] arr = {2, 5, 5, 7};
        int k = 3;
        long expected = 5;
        Assertions.assertEquals(expected, solution6329.makeSubKSumEqual(arr, k));
    }
}