import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6364Tests {
    private final Solution6364 solution6364 = new Solution6364();

    @Test
    public void example1() {
        int[] reward1 = {1, 1, 3, 4};
        int[] reward2 = {4, 4, 1, 1};
        int k = 2;
        int expected = 15;
        Assertions.assertEquals(expected, solution6364.miceAndCheese(reward1, reward2, k));
    }

    @Test
    public void example2() {
        int[] reward1 = {1, 1};
        int[] reward2 = {1, 1};
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution6364.miceAndCheese(reward1, reward2, k));
    }
}