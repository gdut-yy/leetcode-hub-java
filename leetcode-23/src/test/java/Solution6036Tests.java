import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6036Tests {
    private final Solution6036 solution6036 = new Solution6036();

    @Test
    public void example1() {
        String s = "babab";
        int expected = 9;
        Assertions.assertEquals(expected, solution6036.sumScores(s));
    }

    @Test
    public void example2() {
        String s = "azbazbzaz";
        int expected = 14;
        Assertions.assertEquals(expected, solution6036.sumScores(s));
    }

    // 补充用例
    @Test
    public void example3() {
        // 132 / 143 个通过测试用例
        String s = UtUtils.loadingString("solution5219-example3-input.txt", 0);
        int expected = 80001;
        Assertions.assertEquals(expected, solution6036.sumScores(s));
    }

    @Test
    public void example3_2() {
        // 132 / 143 个通过测试用例
        String s = UtUtils.loadingString("solution5219-example3-input.txt", 0);
        int expected = 80001;
        Assertions.assertEquals(expected, solution6036.sumScores2(s));
    }
}
