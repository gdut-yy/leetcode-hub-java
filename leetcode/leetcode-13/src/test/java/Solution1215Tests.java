import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1215Tests {
    private final Solution1215 solution1215 = new Solution1215();

    @Test
    public void example1() {
        int low = 0;
        int high = 21;
        List<Integer> expected = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 21);
        Assertions.assertEquals(expected, solution1215.countSteppingNumbers(low, high));
    }
}