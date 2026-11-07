import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4081Tests {
    private final Solution4081 solution4081 = new Solution4081();

    @Test
    public void example1() {
        int n = 7;
        int s = 20;
        List<Integer> expected = List.of(2, 3, 5, 7);
        Assertions.assertEquals(expected, solution4081.maxPrimeSubset(n, s));
    }

    @Test
    public void example2() {
        int n = 15;
        int s = 18;
        List<Integer> expected = List.of(5, 13);
        Assertions.assertEquals(expected, solution4081.maxPrimeSubset(n, s));
    }

    @Test
    public void example3() {
        int n = 5;
        int s = 1;
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution4081.maxPrimeSubset(n, s));
    }
}
