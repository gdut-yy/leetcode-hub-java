public class Solution3379 {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int j = ((i + nums[i]) % n + n) % n;
            res[i] = nums[j];
        }
        return res;
    }
}
/*
3379. 转换数组
https://leetcode.cn/problems/transformed-array/description/

第 427 场周赛 T1。

给你一个整数数组 nums，它表示一个循环数组。请你遵循以下规则创建一个大小 相同 的新数组 result ：
对于每个下标 i（其中 0 <= i < nums.length），独立执行以下操作：
- 如果 nums[i] > 0：从下标 i 开始，向 右 移动 nums[i] 步，在循环数组中落脚的下标对应的值赋给 result[i]。
- 如果 nums[i] < 0：从下标 i 开始，向 左 移动 abs(nums[i]) 步，在循环数组中落脚的下标对应的值赋给 result[i]。
- 如果 nums[i] == 0：将 nums[i] 的值赋给 result[i]。
返回新数组 result。
注意：由于 nums 是循环数组，向右移动超过最后一个元素时将回到开头，向左移动超过第一个元素时将回到末尾。
提示：
1 <= nums.length <= 100
-100 <= nums[i] <= 100

模拟。
 */