import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution418Tests {
    private final Solution418 solution418 = new Solution418();

    @Test
    public void example1() {
        String[] sentence = {"hello", "world"};
        int rows = 2;
        int cols = 8;
        int expected = 1;
        Assertions.assertEquals(expected, solution418.wordsTyping(sentence, rows, cols));
    }

    @Test
    public void example2() {
        String[] sentence = {"a", "bcd", "e"};
        int rows = 3;
        int cols = 6;
        int expected = 2;
        Assertions.assertEquals(expected, solution418.wordsTyping(sentence, rows, cols));
    }

    @Test
    public void example3() {
        String[] sentence = {"I", "had", "apple", "pie"};
        int rows = 4;
        int cols = 5;
        int expected = 1;
        Assertions.assertEquals(expected, solution418.wordsTyping(sentence, rows, cols));
    }
}
