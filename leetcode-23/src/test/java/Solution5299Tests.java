import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5299Tests {
    private final Solution5299 solution5299 = new Solution5299();

    @Test
    public void example1() {
        int num = 240;
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution5299.divisorSubstrings(num, k));
    }

    @Test
    public void example2() {
        int num = 430043;
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution5299.divisorSubstrings(num, k));
    }
}
