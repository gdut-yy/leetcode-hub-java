import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Hust10242023T3Tests {
    private final Hust10242023T3 solution = new Hust10242023T3();

    @Test
    public void example1() {
        String equation = "x+5-3+x=6+x-2";
        String expected = "x=2";
        Assertions.assertEquals(expected, solution.mathProblem(equation));
    }

    @Test
    public void example2() {
        String equation = "x=x";
        String expected = "Infinite solutions";
        Assertions.assertEquals(expected, solution.mathProblem(equation));
    }

    @Test
    public void example3() {
        String equation = "2x=x";
        String expected = "x=0";
        Assertions.assertEquals(expected, solution.mathProblem(equation));
    }
}
