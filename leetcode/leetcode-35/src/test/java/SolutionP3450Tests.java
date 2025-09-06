import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3450Tests {
    private final SolutionP3450 solutionP3450 = new SolutionP3450();

    @Test
    public void example1() {
        int[][] students = UtUtils.stringToInts2("[[1,2],[2,2],[3,3],[1,3],[2,3]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3450.maxStudentsOnBench(students));
    }

    @Test
    public void example2() {
        int[][] students = UtUtils.stringToInts2("[[1,1],[2,1],[3,1],[4,2],[5,2]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3450.maxStudentsOnBench(students));
    }

    @Test
    public void example3() {
        int[][] students = UtUtils.stringToInts2("[[1,1],[1,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solutionP3450.maxStudentsOnBench(students));
    }

    @Test
    public void example4() {
        int[][] students = UtUtils.stringToInts2("[]");
        int expected = 0;
        Assertions.assertEquals(expected, solutionP3450.maxStudentsOnBench(students));
    }
}