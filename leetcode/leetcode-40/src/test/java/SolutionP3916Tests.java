import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3916Tests {
    private final SolutionP3916 solutionP3916 = new SolutionP3916();

    @Test
    public void example1() {
        int n = 3;
        int l = 4;
        int r = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3916.zigZagArrays(n, l, r));
    }

    @Test
    public void example2() {
        int n = 3;
        int l = 1;
        int r = 3;
        int expected = 10;
        Assertions.assertEquals(expected, solutionP3916.zigZagArrays(n, l, r));
    }
}
