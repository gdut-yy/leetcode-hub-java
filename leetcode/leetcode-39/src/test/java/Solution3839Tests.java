import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3839Tests {
    private final Solution3839 solution3839 = new Solution3839();

    @Test
    public void example1() {
        String[] words = {"apple", "apply", "banana", "bandit"};
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution3839.prefixConnected(words, k));
    }

    @Test
    public void example2() {
        String[] words = {"car", "cat", "cartoon"};
        int k = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution3839.prefixConnected(words, k));
    }

    @Test
    public void example3() {
        String[] words = {"bat", "dog", "dog", "doggy", "bat"};
        int k = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution3839.prefixConnected(words, k));
    }
}