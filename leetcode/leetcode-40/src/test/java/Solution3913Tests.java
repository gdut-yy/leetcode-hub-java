import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3913Tests {
    private final Solution3913 solution3913 = new Solution3913();

    @Test
    public void example1() {
        String s = "leetcode";
        String expected = "leetcedo";
        Assertions.assertEquals(expected, solution3913.sortVowels(s));
    }

    @Test
    public void example2() {
        String s = "aeiaaioooa";
        String expected = "aaaaoooiie";
        Assertions.assertEquals(expected, solution3913.sortVowels(s));
    }

    @Test
    public void example3() {
        String s = "baeiou";
        String expected = "baeiou";
        Assertions.assertEquals(expected, solution3913.sortVowels(s));
    }
}