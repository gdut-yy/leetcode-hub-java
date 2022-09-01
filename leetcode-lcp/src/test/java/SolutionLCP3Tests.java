import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP3Tests {
    private final SolutionLCP3 solutionLCP3 = new SolutionLCP3();

    @Test
    public void example1() {
        String command = "URR";
        int[][] obstacles = UtUtils.stringToInts2("[]");
        int x = 3;
        int y = 2;
        Assertions.assertTrue(solutionLCP3.robot(command, obstacles, x, y));
    }

    @Test
    public void example2() {
        String command = "URR";
        int[][] obstacles = UtUtils.stringToInts2("[[2, 2]]");
        int x = 3;
        int y = 2;
        Assertions.assertFalse(solutionLCP3.robot(command, obstacles, x, y));
    }

    @Test
    public void example3() {
        String command = "URR";
        int[][] obstacles = UtUtils.stringToInts2("[[4, 2]]");
        int x = 3;
        int y = 2;
        Assertions.assertTrue(solutionLCP3.robot(command, obstacles, x, y));
    }
}
