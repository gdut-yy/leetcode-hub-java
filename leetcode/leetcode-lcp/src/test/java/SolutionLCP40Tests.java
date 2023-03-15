import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP40Tests {
    private final SolutionLCP40 solutionLCP40 = new SolutionLCP40();

    @Test
    public void example1() {
        int[] cards = {1, 2, 8, 9};
        int cnt = 3;
        int expected = 18;
        Assertions.assertEquals(expected, solutionLCP40.maxmiumScore(cards, cnt));
    }

    @Test
    public void example2() {
        int[] cards = {3, 3, 1};
        int cnt = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solutionLCP40.maxmiumScore(cards, cnt));
    }
}
