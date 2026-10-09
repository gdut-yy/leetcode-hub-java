import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP666Tests {
    @Test
    public void example1() {
        int[] nums = {113, 215, 221};
        int expected = 12;
        // 每次调用会累加内部状态，需使用新实例
        Assertions.assertEquals(expected, new SolutionP666().pathSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {113, 221};
        int expected = 4;
        Assertions.assertEquals(expected, new SolutionP666().pathSum(nums));
    }
}
