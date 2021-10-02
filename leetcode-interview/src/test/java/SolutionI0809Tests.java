import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionI0809Tests {
    private final SolutionI0809 solutionI0809 = new SolutionI0809();

    @Test
    public void example1() {
        int n = 3;
        List<String> expected = List.of("((()))", "(()())", "(())()", "()(())", "()()()");
        Assertions.assertEquals(expected, solutionI0809.generateParenthesis(n));
    }
}
