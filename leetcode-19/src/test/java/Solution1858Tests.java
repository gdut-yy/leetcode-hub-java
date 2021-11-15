import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1858Tests {
    private final Solution1858 solution1858 = new Solution1858();

    @Test
    public void example1() {
        String[] words = {"k", "ki", "kir", "kira", "kiran"};
        String expected = "kiran";
        Assertions.assertEquals(expected, solution1858.longestWord(words));
    }

    @Test
    public void example2() {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String expected = "apple";
        Assertions.assertEquals(expected, solution1858.longestWord(words));
    }

    @Test
    public void example3() {
        String[] words = {"abc", "bc", "ab", "qwe"};
        String expected = "";
        Assertions.assertEquals(expected, solution1858.longestWord(words));
    }
}
