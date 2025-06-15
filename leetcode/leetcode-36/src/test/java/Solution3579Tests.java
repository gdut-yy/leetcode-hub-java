import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3579Tests {
    private final Solution3579 solution3579 = new Solution3579();

    @Test
    public void example1() {
        String word1 = "abcdf";
        String word2 = "dacbe";
        int expected = 4;
        Assertions.assertEquals(expected, solution3579.minOperations(word1, word2));
    }

    @Test
    public void example2() {
        String word1 = "abceded";
        String word2 = "baecfef";
        int expected = 4;
        Assertions.assertEquals(expected, solution3579.minOperations(word1, word2));
    }

    @Test
    public void example3() {
        String word1 = "abcdef";
        String word2 = "fedabc";
        int expected = 2;
        Assertions.assertEquals(expected, solution3579.minOperations(word1, word2));
    }
}