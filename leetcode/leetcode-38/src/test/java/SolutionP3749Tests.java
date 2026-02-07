import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3749Tests {
    private final SolutionP3749 solutionP3749 = new SolutionP3749();

    @Test
    public void example1() {
        String expression = "add(2,3)";
        long expected = 5;
        Assertions.assertEquals(expected, solutionP3749.evaluateExpression(expression));
    }

    @Test
    public void example2() {
        String expression = "-42";
        long expected = -42;
        Assertions.assertEquals(expected, solutionP3749.evaluateExpression(expression));
    }

    @Test
    public void example3() {
        String expression = "div(mul(4,sub(9,5)),add(1,1))";
        long expected = 8;
        Assertions.assertEquals(expected, solutionP3749.evaluateExpression(expression));
    }
}