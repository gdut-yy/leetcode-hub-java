import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3893Tests {
    private final SolutionP3893 solutionP3893 = new SolutionP3893();

    @Test
    public void example1() {
        int[] startTime = UtUtils.stringToInts("[1,2,3]");
        int[] endTime = UtUtils.stringToInts("[4,5,6]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3893.maximumTeamSize(startTime, endTime));
    }

    @Test
    public void example2() {
        int[] startTime = UtUtils.stringToInts("[2,5,8]");
        int[] endTime = UtUtils.stringToInts("[3,7,9]");
        int expected = 1;
        Assertions.assertEquals(expected, solutionP3893.maximumTeamSize(startTime, endTime));
    }

    @Test
    public void example3() {
        int[] startTime = UtUtils.stringToInts("[3,4,6]");
        int[] endTime = UtUtils.stringToInts("[8,5,7]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3893.maximumTeamSize(startTime, endTime));
    }
}
