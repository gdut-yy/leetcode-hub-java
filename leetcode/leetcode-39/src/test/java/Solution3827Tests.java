import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3827Tests {
    private final Solution3827 solution3827 = new Solution3827();

    @Test
    public void example1() {
        int n = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution3827.countMonobit(n));
    }

    @Test
    public void example2() {
        int n = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution3827.countMonobit(n));
    }
}