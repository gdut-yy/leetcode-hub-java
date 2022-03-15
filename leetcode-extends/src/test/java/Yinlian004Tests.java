import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Yinlian004Tests {
    private final Yinlian004 yinlian004 = new Yinlian004();

    @Test
    public void example1() {
        int[][] skills = {{1, 2, 3}, {3}, {2, 4}};
        int expected = 2;
        Assertions.assertEquals(expected, yinlian004.coopDevelop(skills));
    }

    @Test
    public void example2() {
        int[][] skills = {{3}, {6}};
        int expected = 1;
        Assertions.assertEquals(expected, yinlian004.coopDevelop(skills));
    }

    // 补充用例
    @Test
    public void example3() {
        int[][] skills = UtUtils.loadingInts2("yinlian/yinlian004-example3-input.txt", 0);
        int expected = 41381342;
        Assertions.assertEquals(expected, yinlian004.coopDevelop(skills));
    }
}
