import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3846Tests {
    private final SolutionP3846 solutionP3846 = new SolutionP3846();

    @Test
    public void example1() {
        String s = "hello";
        int expected = 17;
        Assertions.assertEquals(expected, solutionP3846.totalDistance(s));
    }

    @Test
    public void example2() {
        String s = "a";
        int expected = 0;
        Assertions.assertEquals(expected, solutionP3846.totalDistance(s));
    }
}
