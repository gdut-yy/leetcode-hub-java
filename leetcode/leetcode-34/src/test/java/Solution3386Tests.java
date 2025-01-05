import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3386Tests {
    private final Solution3386 solution3386 = new Solution3386();

    @Test
    public void example1() {
        int[][] events = UtUtils.stringToInts2("[[1,2],[2,5],[3,9],[1,15]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution3386.buttonWithLongestTime(events));
    }

    @Test
    public void example2() {
        int[][] events = UtUtils.stringToInts2("[[10,5],[1,7]]");
        int expected = 10;
        Assertions.assertEquals(expected, solution3386.buttonWithLongestTime(events));
    }
}