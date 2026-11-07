import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4079Tests {
    private final Solution4079 solution4079 = new Solution4079();

    @Test
    public void example1() {
        int n = 7;
        int s = 20;
        List<Integer> expected = List.of(2, 3, 5, 7);
        Assertions.assertEquals(expected, solution4079.maxPrimes(n, s));
    }

    @Test
    public void example2() {
        int n = 15;
        int s = 15;
        List<Integer> actual = solution4079.maxPrimes(n, s);
        boolean isOptimal = actual.equals(List.of(2, 3, 5))
                || actual.equals(List.of(2, 3, 7))
                || actual.equals(List.of(2, 5, 7))
                || actual.equals(List.of(3, 5, 7));
        Assertions.assertTrue(isOptimal);
    }

    @Test
    public void example3() {
        int n = 5;
        int s = 1;
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution4079.maxPrimes(n, s));
    }
}
