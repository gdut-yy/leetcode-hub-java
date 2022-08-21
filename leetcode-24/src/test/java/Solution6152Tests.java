import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6152Tests {
    private final Solution6152 solution6152 = new Solution6152();

    @Test
    public void example1() {
        int initialEnergy = 5;
        int initialExperience = 3;
        int[] energy = {1, 4, 3, 2};
        int[] experience = {2, 6, 3, 1};
        int expected = 8;
        Assertions.assertEquals(expected, solution6152.minNumberOfHours(initialEnergy, initialExperience, energy, experience));
    }

    @Test
    public void example2() {
        int initialEnergy = 2;
        int initialExperience = 4;
        int[] energy = {1};
        int[] experience = {3};
        int expected = 0;
        Assertions.assertEquals(expected, solution6152.minNumberOfHours(initialEnergy, initialExperience, energy, experience));
    }
}
