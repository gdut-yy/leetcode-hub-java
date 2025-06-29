import java.util.HashMap;
import java.util.Map;

public class Solution3591 {
    public boolean checkPrimeFrequency(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) cnt.merge(v, 1, Integer::sum);

        for (Integer c : cnt.values()) {
            if (isPrime(c)) return true;
        }
        return false;
    }

    private boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i * i <= num; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
/*
3591. 检查元素频次是否为质数
https://leetcode.cn/problems/check-if-any-element-has-prime-frequency/description/

第 455 场周赛 T1。

给你一个整数数组 nums。
如果数组中任一元素的 频次 是 质数，返回 true；否则，返回 false。
元素 x 的 频次 是它在数组中出现的次数。
质数是一个大于 1 的自然数，并且只有两个因数：1 和它本身。
提示：
1 <= nums.length <= 100
0 <= nums[i] <= 100

模拟 + 判断素数。
时间复杂度 O(n sqrt(n))
 */