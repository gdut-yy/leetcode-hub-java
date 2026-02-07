import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3711Tests {
    private final SolutionP3711 solutionP3711 = new SolutionP3711();

    @Test
    public void example1() {
        int[] transactions = {2, -5, 3, -1, -2};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP3711.maxTransactions(transactions));
    }

    @Test
    public void example2() {
        int[] transactions = {-1, -2, -3};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP3711.maxTransactions(transactions));
    }

    @Test
    public void example3() {
        int[] transactions = {3, -2, 3, -2, 1, -1};
        int expected = 6;
        Assertions.assertEquals(expected, solutionP3711.maxTransactions(transactions));
    }
}