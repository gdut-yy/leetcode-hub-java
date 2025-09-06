import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3666Tests {
    private final Solution3666 solution3666 = new Solution3666();

    @Test
    public void example1() {
        String s = "110";
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution3666.minOperations(s, k));
    }

    @Test
    public void example2() {
        String s = "0101";
        int k = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution3666.minOperations(s, k));
    }

    @Test
    public void example3() {
        String s = "101";
        int k = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solution3666.minOperations(s, k));
    }
}