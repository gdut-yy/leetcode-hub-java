import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO57_2Tests {
    private final SolutionO57_2 solutionO57_2 = new SolutionO57_2();

    @Test
    public void example1() {
        int target = 9;
        int[][] expected = UtUtils.stringToInts2("[[2,3,4],[4,5]]");
        Assertions.assertArrayEquals(expected, solutionO57_2.findContinuousSequence(target));
    }

    @Test
    public void example2() {
        int target = 15;
        int[][] expected = UtUtils.stringToInts2("[[1,2,3,4,5],[4,5,6],[7,8]]");
        Assertions.assertArrayEquals(expected, solutionO57_2.findContinuousSequence(target));
    }
}
