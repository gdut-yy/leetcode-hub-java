import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3522Tests {
    private final Solution3522 solution3522 = new Solution3522();

    @Test
    public void example1() {
        String[] instructions = {"jump", "add", "add", "jump", "add", "jump"};
        int[] values = {2, 1, 3, 1, -2, -3};
        long expected = 1;
        Assertions.assertEquals(expected, solution3522.calculateScore(instructions, values));
    }

    @Test
    public void example2() {
        String[] instructions = {"jump", "add", "add"};
        int[] values = {3, 1, 1};
        long expected = 0;
        Assertions.assertEquals(expected, solution3522.calculateScore(instructions, values));
    }

    @Test
    public void example3() {
        String[] instructions = {"jump"};
        int[] values = {0};
        long expected = 0;
        Assertions.assertEquals(expected, solution3522.calculateScore(instructions, values));
    }
}