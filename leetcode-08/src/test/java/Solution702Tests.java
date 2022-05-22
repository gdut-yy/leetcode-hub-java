import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution702Tests {
    private final Solution702 solution702 = new Solution702();

    @Test
    public void example1() {
        int[] secret = {-1, 0, 3, 5, 9, 12};
        Solution702.ArrayReader reader = new Solution702.ArrayReaderImpl(secret);
        int target = 9;
        int expected = 4;
        Assertions.assertEquals(expected, solution702.search(reader, target));
    }

    @Test
    public void example2() {
        int[] secret = {-1, 0, 3, 5, 9, 12};
        Solution702.ArrayReader reader = new Solution702.ArrayReaderImpl(secret);
        int target = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solution702.search(reader, target));
    }
}
