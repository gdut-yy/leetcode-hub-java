import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3861Tests {
    private final Solution3861 solution3861 = new Solution3861();

    @Test
    public void example1() {
        int[] capacity = {1, 5, 3, 7};
        int itemSize = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution3861.minimumIndex(capacity, itemSize));
    }

    @Test
    public void example2() {
        int[] capacity = {3, 5, 4, 3};
        int itemSize = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution3861.minimumIndex(capacity, itemSize));
    }

    @Test
    public void example3() {
        int[] capacity = {4};
        int itemSize = 5;
        int expected = -1;
        Assertions.assertEquals(expected, solution3861.minimumIndex(capacity, itemSize));
    }
}