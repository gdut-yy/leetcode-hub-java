import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP42Tests {
    private final SolutionLCP42 solutionLCP42 = new SolutionLCP42();

    @Test
    public void example1() {
        int[][] toys = UtUtils.stringToInts2("[[3,3,1],[3,2,1]]");
        int[][] circles = UtUtils.stringToInts2("[[4,3]]");
        int r = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCP42.circleGame(toys, circles, r));
    }

    @Test
    public void example2() {
        int[][] toys = UtUtils.stringToInts2("[[1,3,2],[4,3,1],[7,1,2]]");
        int[][] circles = UtUtils.stringToInts2("[[1,0],[3,3]]");
        int r = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCP42.circleGame(toys, circles, r));
    }
}
