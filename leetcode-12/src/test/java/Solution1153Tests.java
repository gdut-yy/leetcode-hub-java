import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1153Tests {
    private final Solution1153 solution1153 = new Solution1153();

    @Test
    public void example1() {
        String str1 = "aabcc";
        String str2 = "ccdee";
        Assertions.assertTrue(solution1153.canConvert(str1, str2));
    }

    @Test
    public void example2() {
        String str1 = "leetcode";
        String str2 = "codeleet";
        Assertions.assertFalse(solution1153.canConvert(str1, str2));
    }
}