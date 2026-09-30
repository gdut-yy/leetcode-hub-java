import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution749Tests {
    private final Solution749 solution749 = new Solution749();

    @Test
    public void example1() {
        int[][] isInfected = UtUtils.stringToInts2("[[0,1,0,0,0,0,0,1],[0,1,0,0,0,0,0,1],[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0]]");
        int expected = 10;
        Assertions.assertEquals(expected, solution749.containVirus(isInfected));
    }

    @Test
    public void example2() {
        int[][] isInfected = UtUtils.stringToInts2("[[1,1,1],[1,0,1],[1,1,1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution749.containVirus(isInfected));
    }

    @Test
    public void example3() {
        int[][] isInfected = UtUtils.stringToInts2("[[1,1,1,0,0,0,0,0,0],[1,0,1,0,1,1,1,1,1],[1,1,1,0,0,0,0,0,0]]");
        int expected = 13;
        Assertions.assertEquals(expected, solution749.containVirus(isInfected));
    }
}
