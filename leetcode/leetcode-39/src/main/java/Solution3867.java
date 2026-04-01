import java.util.Arrays;

public class Solution3867 {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int mx = nums[0];
        int[] prefixGcd = new int[n];
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            prefixGcd[i] = getGCD(nums[i], mx);
        }
        Arrays.sort(prefixGcd);
        long ans = 0;
        for (int i = 0; i < n / 2; i++) {
            int a = prefixGcd[i], b = prefixGcd[n - 1 - i];
            ans += getGCD(a, b);
        }
        return ans;
    }

    private int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
3867. 数对的最大公约数之和
https://leetcode.cn/problems/sum-of-gcd-of-formed-pairs/description/

第 178 场双周赛 T2。

给你一个长度为 n 的整数数组 nums。
构造一个数组 prefixGcd，其中对于每个下标 i：
- 令 mxi = max(nums[0], nums[1], ..., nums[i])。
- prefixGcd[i] = gcd(nums[i], mxi)。
在构造 prefixGcd 之后：
- 将 prefixGcd 按 非递减 顺序排序。
- 通过取 最小的未配对 元素和 最大的未配对 元素来形成数对。
- 重复此过程，直到无法再形成更多数对。
- 对于每个形成的数对，计算 两个元素的最大公约数 gcd。
- 如果 n 是奇数，prefixGcd 数组中的 中间 元素保持 未配对 状态，并应被忽略。
返回一个整数，表示所有形成数对的 最大公约数之和。
术语 gcd(a, b) 表示 a 和 b 的 最大公约数。
提示：
1 <= n == nums.length <= 10^5
1 <= nums[i] <= 10^9

模拟。
时间复杂度 O(nlogU + nlogn)。
 */