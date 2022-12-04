import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6253Tests {
    private final Solution6253 solution6253 = new Solution6253();

    @Test
    public void example1() {
        String sentence = "leetcode exercises sound delightful";
        Assertions.assertTrue(solution6253.isCircularSentence(sentence));
    }

    @Test
    public void example2() {
        String sentence = "eetcode";
        Assertions.assertTrue(solution6253.isCircularSentence(sentence));
    }

    @Test
    public void example3() {
        String sentence = "Leetcode is cool";
        Assertions.assertFalse(solution6253.isCircularSentence(sentence));
    }
}
