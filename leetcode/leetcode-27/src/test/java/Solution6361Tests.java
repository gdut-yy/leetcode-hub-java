import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6361Tests {
    private final Solution6361 solution6361 = new Solution6361();

    @Test
    public void example1() {
        int[][] nums = UtUtils.stringToInts2("[[1,2,3],[5,6,7],[9,10,11]]");
        int expected = 11;
        Assertions.assertEquals(expected, solution6361.diagonalPrime(nums));
    }

    @Test
    public void example2() {
        int[][] nums = UtUtils.stringToInts2("[[1,2,3],[5,17,7],[9,11,10]]");
        int expected = 17;
        Assertions.assertEquals(expected, solution6361.diagonalPrime(nums));
    }
}