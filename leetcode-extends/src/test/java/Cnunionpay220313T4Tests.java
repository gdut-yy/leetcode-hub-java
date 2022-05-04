import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Cnunionpay220313T4Tests {
    private final Cnunionpay220313T4 cnunionpay220313T4 = new Cnunionpay220313T4();

    @Test
    public void example1() {
        int[][] skills = UtUtils.stringToInts2("[[1,2,3],[3],[2,4]]");
        int expected = 2;
        Assertions.assertEquals(expected, cnunionpay220313T4.coopDevelop(skills));
    }

    @Test
    public void example2() {
        int[][] skills = UtUtils.stringToInts2("[[3],[6]]");
        int expected = 1;
        Assertions.assertEquals(expected, cnunionpay220313T4.coopDevelop(skills));
    }

    // 补充用例
    @Test
    public void example3() {
        int[][] skills = UtUtils.loadingInts2("cnunionpay/220313T4-example3-input.txt", 0);
        int expected = 41381342;
        Assertions.assertEquals(expected, cnunionpay220313T4.coopDevelop(skills));
    }

    @Test
    public void example4() {
        int[][] skills = UtUtils.loadingInts2("cnunionpay/220313T4-example4-input.txt", 0);
        int expected = 338910417;
        Assertions.assertEquals(expected, cnunionpay220313T4.coopDevelop(skills));
    }
}
