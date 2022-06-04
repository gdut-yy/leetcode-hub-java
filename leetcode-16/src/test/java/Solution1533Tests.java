import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1533Tests {
    private final Solution1533 solution1533 = new Solution1533();

    @Test
    public void example1() {
        int[] arr = {7, 7, 7, 7, 10, 7, 7, 7};
        Solution1533.ArrayReader reader = new Solution1533.ArrayReaderImpl(arr);
        int expected = 4;
        Assertions.assertEquals(expected, solution1533.getIndex(reader));
    }

    @Test
    public void example2() {
        int[] arr = {6, 6, 12};
        Solution1533.ArrayReader reader = new Solution1533.ArrayReaderImpl(arr);
        int expected = 2;
        Assertions.assertEquals(expected, solution1533.getIndex(reader));
    }
}
