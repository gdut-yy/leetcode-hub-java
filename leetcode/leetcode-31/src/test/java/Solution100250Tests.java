import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100250Tests {
    private final Solution100250 solution100250 = new Solution100250();

    @Test
    public void example1() {
        int[] possible = {1, 0, 1, 0};
        int expected = 1;
        Assertions.assertEquals(expected, solution100250.minimumLevels(possible));
    }

    @Test
    public void example2() {
        int[] possible = {1, 1, 1, 1, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution100250.minimumLevels(possible));
    }

    @Test
    public void example3() {
        int[] possible = {0, 0};
        int expected = -1;
        Assertions.assertEquals(expected, solution100250.minimumLevels(possible));
    }
}