import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP66Tests {
    private final SolutionLCP66 solutionLCP66 = new SolutionLCP66();

    @Test
    public void example1() {
        String[] demand = {"acd", "bed", "accd"};
        int expected = 6;
        Assertions.assertEquals(expected, solutionLCP66.minNumBooths(demand));
    }

    @Test
    public void example2() {
        String[] demand = {"abc", "ab", "ac", "b"};
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP66.minNumBooths(demand));
    }
}
