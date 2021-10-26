import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO14_2Tests {
    private final SolutionO14_2 solutionO14_2 = new SolutionO14_2();

    @Test
    public void example1() {
        int n = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solutionO14_2.cuttingRope(n));
    }

    @Test
    public void example2() {
        int n = 10;
        int expected = 36;
        Assertions.assertEquals(expected, solutionO14_2.cuttingRope(n));
    }

    // 补充用例
    @Test
    public void example3() {
        int n = 120;
        int expected = 953271190;
        Assertions.assertEquals(expected, solutionO14_2.cuttingRope(n));
    }
}
