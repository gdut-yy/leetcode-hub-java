import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3968Tests {
    private final Solution3968 solution = new Solution3968();

    @Test
    public void example1() {
        String moves = "L_D_";
        int expected = 4;
        Assertions.assertEquals(expected, solution.maxDistance(moves));
    }

    @Test
    public void example2() {
        String moves = "U_R";
        int expected = 3;
        Assertions.assertEquals(expected, solution.maxDistance(moves));
    }
}