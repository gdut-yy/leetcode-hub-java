import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP78Tests {
    private final SolutionLCP78 solutionLCP78 = new SolutionLCP78();

    @Test
    public void example1() {
        int[][] rampart = UtUtils.stringToInts2("[[0,3],[4,5],[7,9]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP78.rampartDefensiveLine(rampart));
    }

    @Test
    public void example2() {
        int[][] rampart = UtUtils.stringToInts2("[[1,2],[5,8],[11,15],[18,25]]");
        int expected = 4;
        Assertions.assertEquals(expected, solutionLCP78.rampartDefensiveLine(rampart));
    }
}