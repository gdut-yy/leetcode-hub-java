import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCS01Tests {
    private final SolutionLCS01 solutionLCS01 = new SolutionLCS01();

    @Test
    public void example1() {
        int n = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCS01.leastMinutes(n));
    }

    @Test
    public void example2() {
        int n = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCS01.leastMinutes(n));
    }
}
