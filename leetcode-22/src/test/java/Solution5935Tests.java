import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution5935Tests {
    private final Solution5935 solution5935 = new Solution5935();

    @Test
    public void example1() {
        int[] security = {5, 3, 3, 3, 5, 6, 2};
        int time = 2;
        // 返回的日子可以 任意 顺序排列。
        List<Integer> expected = Arrays.asList(2, 3);
        List<Integer> actual = solution5935.goodDaysToRobBank(security, time);
        Collections.sort(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] security = {1, 1, 1, 1, 1};
        int time = 0;
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> actual = solution5935.goodDaysToRobBank(security, time);
        Collections.sort(actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        int[] security = {1, 2, 3, 4, 5, 6};
        int time = 2;
        List<Integer> expected = Arrays.asList();
        List<Integer> actual = solution5935.goodDaysToRobBank(security, time);
        Collections.sort(actual);
        Assertions.assertEquals(expected, actual);
    }
}
