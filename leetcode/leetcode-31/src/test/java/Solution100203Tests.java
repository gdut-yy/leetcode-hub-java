import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100203Tests {
    private final Solution100203 solution100203 = new Solution100203();

    @Test
    public void example1() {
        String word = "abacaba";
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution100203.minimumTimeToInitialState(word, k));
    }

    @Test
    public void example2() {
        String word = "abacaba";
        int k = 4;
        int expected = 1;
        Assertions.assertEquals(expected, solution100203.minimumTimeToInitialState(word, k));
    }

    @Test
    public void example3() {
        String word = "abcbabcd";
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution100203.minimumTimeToInitialState(word, k));
    }
}