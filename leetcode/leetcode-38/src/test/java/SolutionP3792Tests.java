import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3792Tests {
    private final SolutionP3792 solutionP3792 = new SolutionP3792();

    @Test
    public void example1() {
        int n = 3;
        int expected = 127;
        Assertions.assertEquals(expected, solutionP3792.sumOfBlocks(n));
    }

    @Test
    public void example2() {
        int n = 7;
        int expected = 6997165;
        Assertions.assertEquals(expected, solutionP3792.sumOfBlocks(n));
    }
}