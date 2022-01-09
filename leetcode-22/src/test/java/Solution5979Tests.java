import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5979Tests {
    private final Solution5979 solution5979 = new Solution5979();

    @Test
    public void example1() {
        int[] plantTime = {1, 4, 3};
        int[] growTime = {2, 3, 1};
        int expected = 9;
        Assertions.assertEquals(expected, solution5979.earliestFullBloom(plantTime, growTime));
    }

    @Test
    public void example2() {
        int[] plantTime = {1, 2, 3, 2};
        int[] growTime = {2, 1, 2, 1};
        int expected = 9;
        Assertions.assertEquals(expected, solution5979.earliestFullBloom(plantTime, growTime));
    }

    @Test
    public void example3() {
        int[] plantTime = {1};
        int[] growTime = {1};
        int expected = 2;
        Assertions.assertEquals(expected, solution5979.earliestFullBloom(plantTime, growTime));
    }
}
