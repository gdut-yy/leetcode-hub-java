import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tianchi221022T4Tests {
    private final Tianchi221022T4 tianchi221022T4 = new Tianchi221022T4();

    @Test
    public void example1() {
        int[][] present = UtUtils.stringToInts2("[[1,2],[2,3],[3,4]]");
        int limit = 3;
        int expected = 9;
        Assertions.assertEquals(expected, tianchi221022T4.brilliantSurprise(present, limit));
    }

    @Test
    public void example2() {
        int[][] present = UtUtils.stringToInts2("[[1,2,100],[4,5],[3,4]]");
        int limit = 4;
        int expected = 107;
        Assertions.assertEquals(expected, tianchi221022T4.brilliantSurprise(present, limit));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/375762432/ TLE
        int[][] present = UtUtils.loadingInts2("tianchi/221022T4-example3-input.txt", 0);
        int limit = UtUtils.loadingInt("tianchi/221022T4-example3-input.txt", 1);
        int expected = 10395828;
        Assertions.assertEquals(expected, tianchi221022T4.brilliantSurprise(present, limit));
    }
}
