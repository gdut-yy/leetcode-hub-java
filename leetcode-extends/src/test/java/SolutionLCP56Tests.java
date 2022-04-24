import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP56Tests {
    private final SolutionLCP56 solutionLCP56 = new SolutionLCP56();

    @Test
    public void example1() {
        String[] matrix = {">>v", "v^<", "<><"};
        int[] start = {0, 1};
        int[] end = {2, 0};
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCP56.conveyorBelt(matrix, start, end));
    }

    @Test
    public void example2() {
        String[] matrix = {">>v", ">>v", "^<<"};
        int[] start = {0, 0};
        int[] end = {1, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solutionLCP56.conveyorBelt(matrix, start, end));
    }

    @Test
    public void example3() {
        String[] matrix = {">^^>", "<^v>", "^v^<"};
        int[] start = {0, 0};
        int[] end = {1, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP56.conveyorBelt(matrix, start, end));
    }
}
