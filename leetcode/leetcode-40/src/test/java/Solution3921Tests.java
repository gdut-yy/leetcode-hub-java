import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3921Tests {
    private final Solution3921 solution3921 = new Solution3921();

    @Test
    public void example1() {
        String[] events = {"1", "4", "W", "6", "WD"};
        int[] expected = {12, 1};
        Assertions.assertArrayEquals(expected, solution3921.scoreValidator(events));
    }

    @Test
    public void example2() {
        String[] events = {"WD", "NB", "0", "4", "4"};
        int[] expected = {10, 0};
        Assertions.assertArrayEquals(expected, solution3921.scoreValidator(events));
    }

    @Test
    public void example3() {
        String[] events = {"W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W"};
        int[] expected = {0, 10};
        Assertions.assertArrayEquals(expected, solution3921.scoreValidator(events));
    }
}