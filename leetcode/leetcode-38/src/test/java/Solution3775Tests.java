import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3775Tests {
    private final Solution3775 solution3775 = new Solution3775();

    @Test
    public void example1() {
        String s = "cat and mice";
        String expected = "cat dna mice";
        Assertions.assertEquals(expected, solution3775.reverseWords(s));
    }

    @Test
    public void example2() {
        String s = "book is nice";
        String expected = "book is ecin";
        Assertions.assertEquals(expected, solution3775.reverseWords(s));
    }

    @Test
    public void example3() {
        String s = "banana healthy";
        String expected = "banana healthy";
        Assertions.assertEquals(expected, solution3775.reverseWords(s));
    }
}