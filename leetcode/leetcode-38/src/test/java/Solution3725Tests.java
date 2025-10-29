import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3725Tests {
    private final Solution3725 solution3725 = new Solution3725();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[1,2],[3,4]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution3725.countCoprime(mat));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[2,2],[2,2]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution3725.countCoprime(mat));
    }
}