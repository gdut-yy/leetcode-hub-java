import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6071Tests {
    private final Solution6071 solution6071 = new Solution6071();

    @Test
    public void example1() {
        int[] tasks = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution6071.minimumRounds(tasks));
    }

    @Test
    public void example2() {
        int[] tasks = {2, 3, 3};
        int expected = -1;
        Assertions.assertEquals(expected, solution6071.minimumRounds(tasks));
    }
}
