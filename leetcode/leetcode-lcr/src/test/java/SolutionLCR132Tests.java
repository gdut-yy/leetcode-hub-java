import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR132Tests {
    private final SolutionLCR132 solutionLCR132 = new SolutionLCR132();

    @Test
    public void example1() {
        int n = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCR132.cuttingBamboo(n));
    }

    @Test
    public void example2() {
        int n = 10;
        int expected = 36;
        Assertions.assertEquals(expected, solutionLCR132.cuttingBamboo(n));
    }

    // 补充用例
    @Test
    public void example3() {
        int n = 120;
        int expected = 953271190;
        Assertions.assertEquals(expected, solutionLCR132.cuttingBamboo(n));
    }
}
