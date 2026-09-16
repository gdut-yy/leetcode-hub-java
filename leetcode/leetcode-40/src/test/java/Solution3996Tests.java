import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3996Tests {
    private final Solution3996 solution3996 = new Solution3996();

    @Test
    public void example1() {
        int[] start = {1, 1};
        int[] target = {2, 2};
        Assertions.assertTrue(solution3996.canReach(start, target));
    }

    @Test
    public void example2() {
        int[] start = {4, 5};
        int[] target = {6, 6};
        Assertions.assertFalse(solution3996.canReach(start, target));
    }
}