import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP74Tests {
    private final SolutionLCP74 solutionLCP74 = new SolutionLCP74();

    @Test
    public void example1() {
        int[][] forceField = UtUtils.stringToInts2("[[0,0,1],[1,0,1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCP74.fieldOfGreatestBlessing(forceField));
    }

    @Test
    public void example2() {
        int[][] forceField = UtUtils.stringToInts2("[[4,4,6],[7,5,3],[1,6,2],[5,6,3]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP74.fieldOfGreatestBlessing(forceField));
    }
}