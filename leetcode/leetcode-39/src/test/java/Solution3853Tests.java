import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3853Tests {
    private final Solution3853 solution3853 = new Solution3853();

    @Test
    public void example1() {
        String s = "abca";
        int k = 3;
        String expected = "abc";
        Assertions.assertEquals(expected, solution3853.mergeCharacters(s, k));
    }

    @Test
    public void example2() {
        String s = "aabca";
        int k = 2;
        String expected = "abca";
        Assertions.assertEquals(expected, solution3853.mergeCharacters(s, k));
    }

    @Test
    public void example3() {
        String s = "yybyzybz";
        int k = 2;
        String expected = "ybzybz";
        Assertions.assertEquals(expected, solution3853.mergeCharacters(s, k));
    }
}