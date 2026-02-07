import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3758Tests {
    private final SolutionP3758 solutionP3758 = new SolutionP3758();

    @Test
    public void example1() {
        String s = "onefourthree";
        String expected = "143";
        Assertions.assertEquals(expected, solutionP3758.convertNumber(s));
    }

    @Test
    public void example2() {
        String s = "ninexsix";
        String expected = "96";
        Assertions.assertEquals(expected, solutionP3758.convertNumber(s));
    }

    @Test
    public void example3() {
        String s = "zeero";
        String expected = "";
        Assertions.assertEquals(expected, solutionP3758.convertNumber(s));
    }

    @Test
    public void example4() {
        String s = "tw";
        String expected = "";
        Assertions.assertEquals(expected, solutionP3758.convertNumber(s));
    }
}