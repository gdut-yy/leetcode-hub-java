import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP29Tests {
    private final SolutionLCP29 solutionLCP29 = new SolutionLCP29();

    @Test
    public void example1() {
        int num = 3;
        int xPos = 0;
        int yPos = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP29.orchestraLayout(num, xPos, yPos));
    }

    @Test
    public void example2() {
        int num = 4;
        int xPos = 1;
        int yPos = 2;
        int expected = 5;
        Assertions.assertEquals(expected, solutionLCP29.orchestraLayout(num, xPos, yPos));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/210735714/ TLE
        int num = 449572;
        int xPos = 209397;
        int yPos = 306801;
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCP29.orchestraLayout(num, xPos, yPos));
    }
}