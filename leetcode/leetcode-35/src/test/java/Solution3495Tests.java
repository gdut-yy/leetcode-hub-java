import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3495Tests {
    private final Solution3495 solution3495 = new Solution3495();

    @Test
    public void example1() {
        int[][] queries = UtUtils.stringToInts2("[[1,2],[2,4]]");
        long expected = 3;
        Assertions.assertEquals(expected, solution3495.minOperations(queries));
    }

    @Test
    public void example2() {
        int[][] queries = UtUtils.stringToInts2("[[2,6]]");
        long expected = 4;
        Assertions.assertEquals(expected, solution3495.minOperations(queries));
    }
}