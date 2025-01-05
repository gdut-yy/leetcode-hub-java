import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCS03Tests {
    private final SolutionLCS03 solutionLCS03 = new SolutionLCS03();

    @Test
    public void example1() {
        String[] grid = {"110", "231", "221"};
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCS03.largestArea(grid));
    }

    @Test
    public void example2() {
        String[] grid = {"11111100000", "21243101111", "21224101221", "11111101111"};
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCS03.largestArea(grid));
    }
}