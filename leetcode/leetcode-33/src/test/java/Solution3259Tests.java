import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3259Tests {
    private final Solution3259 solution3259 = new Solution3259();

    @Test
    public void example1() {
        int[] energyDrinkA = {1, 3, 1};
        int[] energyDrinkB = {3, 1, 1};
        long expected = 5;
        Assertions.assertEquals(expected, solution3259.maxEnergyBoost(energyDrinkA, energyDrinkB));
    }

    @Test
    public void example2() {
        int[] energyDrinkA = {4, 1, 1};
        int[] energyDrinkB = {1, 1, 3};
        long expected = 7;
        Assertions.assertEquals(expected, solution3259.maxEnergyBoost(energyDrinkA, energyDrinkB));
    }
}