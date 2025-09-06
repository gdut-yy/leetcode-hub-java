import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3253Tests {
    private final SolutionP3253 solutionP3253 = new SolutionP3253();

    @Test
    public void example1() {
        String target = "abcdef";
        String[] words = {"abdef", "abc", "d", "def", "ef"};
        int[] costs = {100, 1, 1, 10, 5};
        int expected = 7;
        Assertions.assertEquals(expected, solutionP3253.minimumCost(target, words, costs));
    }

    @Test
    public void example2() {
        String target = "aaaa";
        String[] words = {"z", "zz", "zzz"};
        int[] costs = {1, 10, 100};
        int expected = -1;
        Assertions.assertEquals(expected, solutionP3253.minimumCost(target, words, costs));
    }
}