import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3771Tests {
    private final Solution3771 solution3771 = new Solution3771();

    @Test
    public void example1() {
        int hp = 11;
        int[] damage = {3, 6, 7};
        int[] requirement = {4, 2, 5};
        long expected = 3;
        Assertions.assertEquals(expected, solution3771.totalScore(hp, damage, requirement));
    }

    @Test
    public void example2() {
        int hp = 2;
        int[] damage = {10000, 1};
        int[] requirement = {1, 1};
        long expected = 1;
        Assertions.assertEquals(expected, solution3771.totalScore(hp, damage, requirement));
    }
}