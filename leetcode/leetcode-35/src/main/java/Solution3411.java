public class Solution3411 {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int gcd = nums[i];
            int lcm = nums[i];
            int prod = nums[i];
            for (int j = i + 1; j < n; j++) {
                gcd = getGCD(gcd, nums[j]);
                lcm = getLCM(lcm, nums[j]);
                prod *= nums[j];
                if (gcd * lcm == prod) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    private int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }

    private int getLCM(int num1, int num2) {
        return num1 / getGCD(num1, num2) * num2;
    }
}
/*
3411. 最长乘积等价子数组
https://leetcode.cn/problems/maximum-subarray-with-equal-products/description/

第 431 场周赛 T1。

给你一个由 正整数 组成的数组 nums。
如果一个数组 arr 满足 prod(arr) == lcm(arr) * gcd(arr)，则称其为 乘积等价数组 ，其中：
- prod(arr) 表示 arr 中所有元素的乘积。
- gcd(arr) 表示 arr 中所有元素的最大公因数 (GCD)。
- lcm(arr) 表示 arr 中所有元素的最小公倍数 (LCM)。
返回数组 nums 的 最长 乘积等价子数组 的长度。
子数组 是数组中连续的、非空的元素序列。
术语 gcd(a, b) 表示 a 和 b 的 最大公因数 。
术语 lcm(a, b) 表示 a 和 b 的 最小公倍数 。
提示：
2 <= nums.length <= 100
1 <= nums[i] <= 10

枚举。
时间复杂度 O(n^2 logU)。
 */