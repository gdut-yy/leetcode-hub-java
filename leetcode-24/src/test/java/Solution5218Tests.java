import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5218Tests {
    private final Solution5218 solution5218 = new Solution5218();

    @Test
    public void example1() {
        int num = 58;
        int k = 9;
        int expected = 2;
        Assertions.assertEquals(expected, solution5218.minimumNumbers(num, k));
    }

    @Test
    public void example2() {
        int num = 37;
        int k = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solution5218.minimumNumbers(num, k));
    }

    @Test
    public void example3() {
        int num = 0;
        int k = 7;
        int expected = 0;
        Assertions.assertEquals(expected, solution5218.minimumNumbers(num, k));
    }
}
