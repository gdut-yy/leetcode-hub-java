import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI1626Tests {
    private final SolutionI1626 solutionI1626 = new SolutionI1626();

    @Test
    public void example1() {
        String s = "3+2*2";
        int expected = 7;
        Assertions.assertEquals(expected, solutionI1626.calculate(s));
    }

    @Test
    public void example2() {
        String s = " 3/2 ";
        int expected = 1;
        Assertions.assertEquals(expected, solutionI1626.calculate(s));
    }

    @Test
    public void example3() {
        String s = " 3+5 / 2 ";
        int expected = 5;
        Assertions.assertEquals(expected, solutionI1626.calculate(s));
    }
}
