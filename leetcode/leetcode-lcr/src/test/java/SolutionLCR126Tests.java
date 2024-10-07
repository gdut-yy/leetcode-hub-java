import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR126Tests {
    private final SolutionLCR126 solutionLCR126 = new SolutionLCR126();

    @Test
    public void example1() {
        int n = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCR126.fib(n));
    }

    @Test
    public void example2() {
        int n = 5;
        int expected = 5;
        Assertions.assertEquals(expected, solutionLCR126.fib(n));
    }

    // 补充用例
    @Test
    public void example3() {
        int n = 45;
        int expected = 134903163;
        Assertions.assertEquals(expected, solutionLCR126.fib(n));
    }
}
