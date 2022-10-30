import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6225Tests {
    private final Solution6225 solution6225 = new Solution6225();

    @Test
    public void example1() {
        String[] words = {"adc", "wzy", "abc"};
        String expected = "abc";
        Assertions.assertEquals(expected, solution6225.oddString(words));
    }

    @Test
    public void example2() {
        String[] words = {"aaa", "bob", "ccc", "ddd"};
        String expected = "bob";
        Assertions.assertEquals(expected, solution6225.oddString(words));
    }
}
