import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP77Tests {
    private final SolutionLCP77 solutionLCP77 = new SolutionLCP77();

    @Test
    public void example1() {
        int[] runes = {1, 3, 5, 4, 1, 7};
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP77.runeReserve(runes));
    }

    @Test
    public void example2() {
        int[] runes = {1, 1, 3, 3, 2, 4};
        int expected = 6;
        Assertions.assertEquals(expected, solutionLCP77.runeReserve(runes));
    }
}