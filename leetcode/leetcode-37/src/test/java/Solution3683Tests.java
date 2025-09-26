import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3683Tests {
    private final Solution3683 solution3683 = new Solution3683();

    @Test
    public void example1() {
        int[][] tasks = UtUtils.stringToInts2("[[1,6],[2,3]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution3683.earliestTime(tasks));
    }

    @Test
    public void example2() {
        int[][] tasks = UtUtils.stringToInts2("[[100,100],[100,100],[100,100]]");
        int expected = 200;
        Assertions.assertEquals(expected, solution3683.earliestTime(tasks));
    }
}