import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3631Tests {
    private final SolutionP3631 solutionP3631 = new SolutionP3631();

    @Test
    public void example1() {
        int[][] threats = UtUtils.stringToInts2("[[101,2,3],[102,3,2],[103,3,3]]");
        int[][] expected = UtUtils.stringToInts2("[[103,3,3],[102,3,2],[101,2,3]]");
        Assertions.assertArrayEquals(expected, solutionP3631.sortThreats(threats));
    }

    @Test
    public void example2() {
        int[][] threats = UtUtils.stringToInts2("[[101,4,1],[103,1,5],[102,1,5]]");
        int[][] expected = UtUtils.stringToInts2("[[101,4,1],[102,1,5],[103,1,5]]");
        Assertions.assertArrayEquals(expected, solutionP3631.sortThreats(threats));
    }
}