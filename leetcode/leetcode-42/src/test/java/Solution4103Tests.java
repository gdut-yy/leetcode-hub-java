import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4103Tests {
    private final Solution4103 solution4103 = new Solution4103();

    @Test
    public void example1() {
        int[] types = {0, 1, 1, 0};
        int[] colors = {5, 3, 3, 5};
        int[] groupSize = {2, 2};
        Assertions.assertTrue(solution4103.canRemoveAll(types, colors, groupSize));
    }

    @Test
    public void example2() {
        int[] types = {0, 1, 0};
        int[] colors = {9, 9, 9};
        int[] groupSize = {3, 2};
        Assertions.assertFalse(solution4103.canRemoveAll(types, colors, groupSize));
    }

    @Test
    public void example3() {
        int[] types = {2, 0, 1, 2};
        int[] colors = {7, 5, 4, 7};
        int[] groupSize = {3, 1, 2};
        Assertions.assertFalse(solution4103.canRemoveAll(types, colors, groupSize));
    }
}
