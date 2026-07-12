import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3964Tests {
    private final Solution3964 solution3964 = new Solution3964();

    @Test
    public void example1() {
        int[] lights = {0, 0, 0, 0};
        int expected = 2;
        Assertions.assertEquals(expected, solution3964.minLights(lights));
    }

    @Test
    public void example2() {
        int[] lights = {0, 0, 0, 2, 0};
        int expected = 1;
        Assertions.assertEquals(expected, solution3964.minLights(lights));
    }
}