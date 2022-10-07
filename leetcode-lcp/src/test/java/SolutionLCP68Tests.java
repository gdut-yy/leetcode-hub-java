import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP68Tests {
    private final SolutionLCP68 solutionLCP68 = new SolutionLCP68();

    @Test
    public void example1() {
        int[] flowers = {1, 2, 3, 2};
        int cnt = 1;
        int expected = 8;
        Assertions.assertEquals(expected, solutionLCP68.beautifulBouquet(flowers, cnt));
    }

    @Test
    public void example2() {
        int[] flowers = {5, 3, 3, 3};
        int cnt = 2;
        int expected = 8;
        Assertions.assertEquals(expected, solutionLCP68.beautifulBouquet(flowers, cnt));
    }
}
