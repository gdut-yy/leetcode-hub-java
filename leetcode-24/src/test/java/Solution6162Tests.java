import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6162Tests {
    private final Solution6162 solution6162 = new Solution6162();

    @Test
    public void example1() {
        String[] garbage = {"G", "P", "GP", "GG"};
        int[] travel = {2, 4, 3};
        int expected = 21;
        Assertions.assertEquals(expected, solution6162.garbageCollection(garbage, travel));
    }

    @Test
    public void example2() {
        String[] garbage = {"MMM", "PGM", "GP"};
        int[] travel = {3, 10};
        int expected = 37;
        Assertions.assertEquals(expected, solution6162.garbageCollection(garbage, travel));
    }
}
