import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4062Tests {
    private final Solution4062 solution4062 = new Solution4062();

    @Test
    public void example1() {
        int[] source = {1, 2, 3};
        int[] target = {0, 2, 4};
        Assertions.assertTrue(solution4062.canTransform(source, target));
    }

    @Test
    public void example2() {
        int[] source = {-5, -5};
        int[] target = {-15, 5};
        Assertions.assertTrue(solution4062.canTransform(source, target));
    }

    @Test
    public void example3() {
        int[] source = {1, 2, 1};
        int[] target = {0, 2, 5};
        Assertions.assertFalse(solution4062.canTransform(source, target));
    }
}
