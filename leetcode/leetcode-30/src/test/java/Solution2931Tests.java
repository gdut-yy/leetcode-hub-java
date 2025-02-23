import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2931Tests {
    private final Solution2931.V1 solution2931 = new Solution2931.V1();
    private final Solution2931.V2 solution2931_v2 = new Solution2931.V2();

    @Test
    public void example1() {
        int[][] values = UtUtils.stringToInts2("[[8,5,2],[6,4,1],[9,7,3]]");
        long expected = 285;
        Assertions.assertEquals(expected, solution2931.maxSpending(values));
        Assertions.assertEquals(expected, solution2931_v2.maxSpending(values));
    }

    @Test
    public void example2() {
        int[][] values = UtUtils.stringToInts2("[[10,8,6,4,2],[9,7,5,3,2]]");
        long expected = 386;
        Assertions.assertEquals(expected, solution2931.maxSpending(values));
        Assertions.assertEquals(expected, solution2931_v2.maxSpending(values));
    }
}