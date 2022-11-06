import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution6232Tests {
    private final Solution6232 solution6232 = new Solution6232();

    @Test
    public void example1() {
        List<Integer> robot = Arrays.asList(0, 4, 6);
        int[][] factory = UtUtils.stringToInts2("[[2,2],[6,2]]");
        long expected = 4;
        Assertions.assertEquals(expected, solution6232.minimumTotalDistance(robot, factory));
        Assertions.assertEquals(expected, solution6232.minimumTotalDistance2(robot, factory));
        Assertions.assertEquals(expected, solution6232.minimumTotalDistance3(robot, factory));
    }

    @Test
    public void example2() {
        List<Integer> robot = Arrays.asList(1, -1);
        int[][] factory = UtUtils.stringToInts2("[[-2,1],[2,1]]");
        long expected = 2;
        Assertions.assertEquals(expected, solution6232.minimumTotalDistance(robot, factory));
        Assertions.assertEquals(expected, solution6232.minimumTotalDistance2(robot, factory));
        Assertions.assertEquals(expected, solution6232.minimumTotalDistance3(robot, factory));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/379724650/
        // KM 算法 TLE
        String fileName = "solution6232-example3-input.txt";
        List<Integer> robot = UtUtils.loadingIntegerList(fileName, 0);
        int[][] factory = UtUtils.loadingInts2(fileName, 1);
        long expected = 876878915;
        Assertions.assertEquals(expected, solution6232.minimumTotalDistance(robot, factory));
        Assertions.assertEquals(expected, solution6232.minimumTotalDistance2(robot, factory));
        Assertions.assertEquals(expected, solution6232.minimumTotalDistance3(robot, factory));
    }
}
