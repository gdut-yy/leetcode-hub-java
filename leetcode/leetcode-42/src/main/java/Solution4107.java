public class Solution4107 {
    public int countSuffix(int[] nums, int[] target) {
        int n = nums.length;
        int firstNotmatch = n;
        for (int i = 0; i < n; i++) {
            if (nums[i] != target[i]) {
                firstNotmatch = i;
                break;
            }
        }
        boolean[] sorted = new boolean[n];
        sorted[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            sorted[i] = target[i] >= target[i + 1] && sorted[i + 1];
        }
        int maxV = 1;
        for (int x : nums) maxV = Math.max(maxV, x);
        for (int x : target) maxV = Math.max(maxV, x);
        int[] diff = new int[maxV + 1];
        int nonZero = 0;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int a = nums[i];
            if (diff[a] == 0) nonZero++;
            diff[a]++;
            if (diff[a] == 0) nonZero--;
            int b = target[i];
            if (diff[b] == 0) nonZero++;
            diff[b]--;
            if (diff[b] == 0) nonZero--;
            if (i <= firstNotmatch && sorted[i] && nonZero == 0) {
                ans++;
            }
        }
        return ans;
    }
}
/*
4107. 统计有效后缀排序的数量 I
https://leetcode.cn/problems/count-valid-suffix-sorts-i/description/

第 527 场周赛 T2。

给你两个长度均为 n 的整数数组 nums 和 target。
对于每个下标 i，考虑将原数组的 后缀 nums[i..n - 1] 按 非递增顺序 排序。
返回使排序后的数组等于 target 的下标 i 的数量。
子数组 是数组中一个连续的 非空 元素序列。
数组的 后缀 是从任意下标开始并延伸至数组末尾的子数组。
示例 1：
输入： nums = [1,2,3], target = [3,2,1]
输出： 1
示例 2：
输入： nums = [1,5,6,4,6], target = [1,5,6,6,4]
输出： 2
示例 3：
输入： nums = [7,6,8], target = [8,6,7]
输出： 0
提示：
1 <= n == nums.length == target.length <= 10^5
1 <= nums[i], target[i] <= 10^5

前缀必须原本就与 target 相同，因此 i 不能超过第一个失配位置；后缀排序后等于 target 后缀，当且仅当 target 后缀非递增，且二者元素频次相同。
从右往左维护频次差，统计合法 i。
时间复杂度 O(n + maxV)。
 */