import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3664Tests {
    private final Solution3664 solution3664 = new Solution3664();

    @Test
    public void example1() {
        String[] cards = {"aa", "ab", "ba", "ac"};
        char x = 'a';
        int expected = 2;
        Assertions.assertEquals(expected, solution3664.score(cards, x));
    }

    @Test
    public void example2() {
        String[] cards = {"aa", "ab", "ba"};
        char x = 'a';
        int expected = 1;
        Assertions.assertEquals(expected, solution3664.score(cards, x));
    }

    @Test
    public void example3() {
        String[] cards = {"aa", "ab", "ba", "ac"};
        char x = 'b';
        int expected = 0;
        Assertions.assertEquals(expected, solution3664.score(cards, x));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/two-letter-card-game/submissions/658008101/
        // 双指针贪心是错误做法
        String[] cards = {"ab", "aa", "ab", "bc", "cc", "bc", "bb", "ac", "bc", "bc", "aa", "aa", "ba", "bc", "cb", "ba", "ac", "bb", "cb", "ac", "cb", "cb", "ba", "bc", "ca", "ba", "bb", "cc", "cc", "ca", "ab", "bb", "bc", "ba", "ac", "bc", "ac", "ac", "bc", "bb", "bc", "ac", "bc", "aa", "ba", "cc", "ac", "bb", "ba", "bb"};
        char x = 'b';
        int expected = 16;
        Assertions.assertEquals(expected, solution3664.score(cards, x));
    }
}