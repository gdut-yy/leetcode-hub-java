import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3568Tests {
    private final Solution3568 solution3568 = new Solution3568();

    @Test
    public void example1() {
        String[] classroom = {"S.", "XL"};
        int energy = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution3568.minMoves(classroom, energy));
    }

    @Test
    public void example2() {
        String[] classroom = {"LS", "RL"};
        int energy = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution3568.minMoves(classroom, energy));
    }

    @Test
    public void example3() {
        String[] classroom = {"L.S", "RXL"};
        int energy = 3;
        int expected = -1;
        Assertions.assertEquals(expected, solution3568.minMoves(classroom, energy));
    }
}