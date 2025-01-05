import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3387Tests {
    private final Solution3387 solution3387 = new Solution3387();

    @Test
    public void example1() {
        String initialCurrency = "EUR";
        List<List<String>> pairs1 = UtUtils.stringToStringList2("""
                [["EUR","USD"],["USD","JPY"]]
                """);
        double[] rates1 = {2.0, 3.0};
        List<List<String>> pairs2 = UtUtils.stringToStringList2("""
                [["JPY","USD"],["USD","CHF"],["CHF","EUR"]]
                """);
        double[] rates2 = {4.0, 5.0, 6.0};
        double expected = 720.00000;
        Assertions.assertEquals(expected, solution3387.maxAmount(initialCurrency, pairs1, rates1, pairs2, rates2));
    }

    @Test
    public void example2() {
        String initialCurrency = "NGN";
        List<List<String>> pairs1 = UtUtils.stringToStringList2("""
                [["NGN","EUR"]]
                """);
        double[] rates1 = {9.0};
        List<List<String>> pairs2 = UtUtils.stringToStringList2("""
                [["NGN","EUR"]]
                """);
        double[] rates2 = {6.0};
        double expected = 1.50000;
        Assertions.assertEquals(expected, solution3387.maxAmount(initialCurrency, pairs1, rates1, pairs2, rates2));
    }

    @Test
    public void example3() {
        String initialCurrency = "USD";
        List<List<String>> pairs1 = UtUtils.stringToStringList2("""
                [["USD","EUR"]]
                """);
        double[] rates1 = {1.0};
        List<List<String>> pairs2 = UtUtils.stringToStringList2("""
                [["EUR","JPY"]]
                """);
        double[] rates2 = {10.0};
        double expected = 1.00000;
        Assertions.assertEquals(expected, solution3387.maxAmount(initialCurrency, pairs1, rates1, pairs2, rates2));
    }
}