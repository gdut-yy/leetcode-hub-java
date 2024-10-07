import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0506Tests {
    private final SolutionI0506 solutionI0506 = new SolutionI0506();

    @Test
    public void example1() {
        int A = 29;
        int B = 15;
        int expected = 2;
        Assertions.assertEquals(expected, solutionI0506.convertInteger(A, B));
    }

    @Test
    public void example2() {
        int A = 1;
        int B = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solutionI0506.convertInteger(A, B));
    }
}