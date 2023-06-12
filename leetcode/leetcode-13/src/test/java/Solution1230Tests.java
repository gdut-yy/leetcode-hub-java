import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1230Tests {
    private final Solution1230 solution1230 = new Solution1230();

    @Test
    public void example1() {
        double[] prob = {0.4};
        int target = 1;
        double expected = 0.40000;
        Assertions.assertEquals(expected, solution1230.probabilityOfHeads(prob, target));
    }

    @Test
    public void example2() {
        double[] prob = {0.5, 0.5, 0.5, 0.5, 0.5};
        int target = 0;
        double expected = 0.03125;
        Assertions.assertEquals(expected, solution1230.probabilityOfHeads(prob, target));
    }
}