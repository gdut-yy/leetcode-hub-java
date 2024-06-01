import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2021Tests {
    private final Solution2021 solution2021 = new Solution2021();

    @Test
    public void example1() {
        int[][] lights = UtUtils.stringToInts2("[[-3,2],[1,2],[3,3]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution2021.brightestPosition(lights));
        Assertions.assertEquals(expected, solution2021.brightestPosition2(lights));
    }

    @Test
    public void example2() {
        int[][] lights = UtUtils.stringToInts2("[[1,0],[0,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution2021.brightestPosition(lights));
        Assertions.assertEquals(expected, solution2021.brightestPosition2(lights));
    }

    @Test
    public void example3() {
        int[][] lights = UtUtils.stringToInts2("[[1,2]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution2021.brightestPosition(lights));
        Assertions.assertEquals(expected, solution2021.brightestPosition2(lights));
    }
}