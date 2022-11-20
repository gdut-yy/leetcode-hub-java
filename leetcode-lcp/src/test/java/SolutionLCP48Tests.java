import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP48Tests {
    private final SolutionLCP48 solutionLCP48 = new SolutionLCP48();

    @Test
    public void example1() {
        int[][] pieces = UtUtils.stringToInts2("[[0,0,1],[1,1,1],[2,2,0]]");
        String expected = "None";
        Assertions.assertEquals(expected, solutionLCP48.gobang(pieces));
    }

    @Test
    public void example2() {
        int[][] pieces = UtUtils.stringToInts2("[[1,2,1],[1,4,1],[1,5,1],[2,1,0],[2,3,0],[2,4,0],[3,2,1],[3,4,0],[4,2,1],[5,2,1]]");
        String expected = "Black";
        Assertions.assertEquals(expected, solutionLCP48.gobang(pieces));
    }
}
