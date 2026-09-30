import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1032Tests {
    @Test
    public void example1() {
        String[] words = {"cd", "f", "kl"};
        Solution1032.StreamChecker streamChecker = new Solution1032.StreamChecker(words);

        // 返回 False
        Assertions.assertFalse(streamChecker.query('a'));

        // 返回 False
        Assertions.assertFalse(streamChecker.query('b'));

        // 返回n False
        Assertions.assertFalse(streamChecker.query('c'));

        // 返回 True ，因为 'cd' 在 words 中
        Assertions.assertTrue(streamChecker.query('d'));

        // 返回 False
        Assertions.assertFalse(streamChecker.query('e'));

        // 返回 True ，因为 'f' 在 words 中
        Assertions.assertTrue(streamChecker.query('f'));

        // 返回 False
        Assertions.assertFalse(streamChecker.query('g'));

        // 返回 False
        Assertions.assertFalse(streamChecker.query('h'));

        // 返回 False
        Assertions.assertFalse(streamChecker.query('i'));

        // 返回 False
        Assertions.assertFalse(streamChecker.query('j'));

        // 返回 False
        Assertions.assertFalse(streamChecker.query('k'));

        // 返回 True ，因为 'kl' 在 words 中
        Assertions.assertTrue(streamChecker.query('l'));
    }
}
