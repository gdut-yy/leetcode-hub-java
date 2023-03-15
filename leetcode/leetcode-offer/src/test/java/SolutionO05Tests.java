import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO05Tests {
    private final SolutionO05 solutionO05 = new SolutionO05();

    @Test
    public void example1() {
        String s = "We are happy.";
        String expected = "We%20are%20happy.";
        Assertions.assertEquals(expected, solutionO05.replaceSpace(s));
    }
}
