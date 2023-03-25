import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2597Tests {
    private final Solution2597 solution2597 = new Solution2597();

    @Test
    public void example1() {
        int[] nums = {2, 4, 6};
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution2597.beautifulSubsets(nums, k));
        Assertions.assertEquals(expected, solution2597.beautifulSubsets2(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1};
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution2597.beautifulSubsets(nums, k));
        Assertions.assertEquals(expected, solution2597.beautifulSubsets2(nums, k));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/415012258/
        // TLE
        int[] nums = {538, 207, 832, 793, 906, 965, 666, 376, 745, 962, 650, 861, 804, 113, 403, 992, 541, 37, 891, 756};
        int k = 443;
        int expected = 786431;
        Assertions.assertEquals(expected, solution2597.beautifulSubsets(nums, k));
        Assertions.assertEquals(expected, solution2597.beautifulSubsets2(nums, k));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/414990678/
        // TLE
        int[] nums = {310, 210, 726, 347, 2, 665, 800, 749, 751, 600, 580, 942, 966, 198, 886, 15, 607, 439, 725, 279};
        int k = 711;
        int expected = 786431;
        Assertions.assertEquals(expected, solution2597.beautifulSubsets(nums, k));
        Assertions.assertEquals(expected, solution2597.beautifulSubsets2(nums, k));
    }
}