import java.util.HashMap;
import java.util.Map;

public class SolutionO39 {
    /**
     * 哈希表法
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int majorityElement(int[] nums) {
        int halfLen = nums.length / 2;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
            if (cntMap.getOrDefault(num, 0) > halfLen) {
                return num;
            }
        }
        return -1;
    }

    /**
     * Boyer-Moore 投票算法
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
/*
剑指 Offer 39. 数组中出现次数超过一半的数字
https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。

Boyer-Moore 投票算法
时间复杂度 O(n)
空间复杂度 O(1)
官方题解: https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-pvh8/

同: 169. 多数元素
https://leetcode-cn.com/problems/majority-element/
 */