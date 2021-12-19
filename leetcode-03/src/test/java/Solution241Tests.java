import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution241Tests {
    private final Solution241 solution241 = new Solution241();

    @Test
    public void example1() {
        String expression = "2-1-1";
        List<Integer> expected = List.of(0, 2);
        Assertions.assertEquals(expected, solution241.diffWaysToCompute(expression));
    }

    @Test
    public void example2() {
        String expression = "2*3-4*5";
        List<Integer> expected = List.of(-34, -14, -10, -10, 10);
        Assertions.assertEquals(expected, solution241.diffWaysToCompute(expression));
    }
}
