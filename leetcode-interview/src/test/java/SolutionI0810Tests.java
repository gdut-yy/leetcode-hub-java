import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0810Tests {
    private final SolutionI0810 solutionI0810 = new SolutionI0810();

    @Test
    public void example1() {
        int[][] image = UtUtils.stringToInts2("[[1,1,1],[1,1,0],[1,0,1]]");
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] expected = UtUtils.stringToInts2("[[2,2,2],[2,2,0],[2,0,1]]");
        Assertions.assertArrayEquals(expected, solutionI0810.floodFill(image, sr, sc, newColor));
    }
}
