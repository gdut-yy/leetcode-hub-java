import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3706Tests {
    private final SolutionP3706 solutionP3706 = new SolutionP3706();

    @Test
    public void example1() {
        String[] words = {"leetcode", "leetcode", "codeforces"};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3706.maxDistance(words));
    }

    @Test
    public void example2() {
        String[] words = {"a", "b", "c", "a", "a"};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP3706.maxDistance(words));
    }

    @Test
    public void example3() {
        String[] words = {"z", "z", "z"};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP3706.maxDistance(words));
    }
}