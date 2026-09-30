import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP4060Tests {
    private final SolutionP4060 solutionP4060 = new SolutionP4060();

    @Test
    public void example1() {
        long l = 18;
        long r = 22;
        long expected = 3;
        Assertions.assertEquals(expected, solutionP4060.countEvenlyGoodIntegers(l, r));
    }

    @Test
    public void example2() {
        long l = 98;
        long r = 101;
        long expected = 2;
        Assertions.assertEquals(expected, solutionP4060.countEvenlyGoodIntegers(l, r));
    }

    @Test
    public void example3() {
        long l = 1;
        long r = 10;
        long expected = 5;
        Assertions.assertEquals(expected, solutionP4060.countEvenlyGoodIntegers(l, r));
    }
}
