import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP4028Tests {
    private final SolutionP4028 solutionP4028 = new SolutionP4028();

    @Test
    public void example1() {
        String s = "abc";
        int expected = 2;
        Assertions.assertEquals(expected, solutionP4028.minOperations(s));
    }

    @Test
    public void example2() {
        String s = "yb";
        int expected = 3;
        Assertions.assertEquals(expected, solutionP4028.minOperations(s));
    }
}
