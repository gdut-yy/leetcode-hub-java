import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution936Tests {
    private final Solution936 solution936 = new Solution936();

    @Test
    public void example1() {
        String stamp = "abc";
        String target = "ababc";
        int[] actual = solution936.movesToStamp(stamp, target);
        Assertions.assertTrue(isValidStamp(stamp, target, actual));
    }

    @Test
    public void example2() {
        String stamp = "abca";
        String target = "aabcaca";
        int[] actual = solution936.movesToStamp(stamp, target);
        Assertions.assertTrue(isValidStamp(stamp, target, actual));
    }

    /**
     * 校验印章序列能否从全 '?' 还原出 target（题目允许多种合法答案）
     */
    private boolean isValidStamp(String stamp, String target, int[] moves) {
        int m = stamp.length();
        int n = target.length();
        char[] cur = new char[n];
        Arrays.fill(cur, '?');
        for (int idx : moves) {
            if (idx < 0 || idx + m > n) {
                return false;
            }
            for (int j = 0; j < m; j++) {
                cur[idx + j] = stamp.charAt(j);
            }
        }
        return new String(cur).equals(target);
    }
}
