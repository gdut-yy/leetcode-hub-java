import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3802Tests {
    private final SolutionP3802 solutionP3802 = new SolutionP3802();

    @Test
    public void example1() {
        int n = 4;
        int[] limit = UtUtils.stringToInts("[3,1,2]");
        int expected = 6;
        Assertions.assertEquals(expected, solutionP3802.numberOfWays(n, limit));
    }

    @Test
    public void example2() {
        int n = 3;
        int[] limit = UtUtils.stringToInts("[1,2]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3802.numberOfWays(n, limit));
    }

    @Test
    public void example3() {
        int n = 3;
        int[] limit = UtUtils.stringToInts("[2,2]");
        int expected = 4;
        Assertions.assertEquals(expected, solutionP3802.numberOfWays(n, limit));
    }
}
