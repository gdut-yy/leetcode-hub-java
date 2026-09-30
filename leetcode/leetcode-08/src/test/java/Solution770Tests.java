import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution770Tests {
    private final Solution770 solution770 = new Solution770();

    @Test
    public void example1() {
        String expression = "e + 8 - a + 5";
        String[] evalVars = {"e"};
        int[] evalInts = {1};
        List<String> expected = List.of("-1*a", "14");
        Assertions.assertEquals(expected, solution770.basicCalculatorIV(expression, evalVars, evalInts));
    }

    @Test
    public void example2() {
        String expression = "e - 8 + temperature - pressure";
        String[] evalVars = {"e", "temperature"};
        int[] evalInts = {1, 12};
        List<String> expected = List.of("-1*pressure", "5");
        Assertions.assertEquals(expected, solution770.basicCalculatorIV(expression, evalVars, evalInts));
    }

    @Test
    public void example3() {
        String expression = "(e + 8) * (e - 8)";
        String[] evalVars = {};
        int[] evalInts = {};
        List<String> expected = List.of("1*e*e", "-64");
        Assertions.assertEquals(expected, solution770.basicCalculatorIV(expression, evalVars, evalInts));
    }
}
