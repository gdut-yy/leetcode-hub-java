import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6368Tests {
    private final Solution6368 solution6368 = new Solution6368();

    @Test
    public void example1() {
        String word = "998244353";
        int m = 3;
        int[] expected = {1, 1, 0, 0, 0, 1, 1, 0, 0};
        Assertions.assertArrayEquals(expected, solution6368.divisibilityArray(word, m));
    }

    @Test
    public void example2() {
        String word = "1010";
        int m = 10;
        int[] expected = {0, 1, 0, 1};
        Assertions.assertArrayEquals(expected, solution6368.divisibilityArray(word, m));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/406285082/
        // 爆 long
        String word = "91221181269244172125025075166510211202115152121212341281327";
        int m = 21;
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        Assertions.assertArrayEquals(expected, solution6368.divisibilityArray(word, m));
    }
}