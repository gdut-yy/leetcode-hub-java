public class SolutionP3431 {
    public int minUnlockedIndices(int[] nums, int[] locked) {
        int n = nums.length;
        int left_3 = n;
        int right_1 = -1;
        int left_2 = n;
        int right_2 = -1;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (x == 3) {
                left_3 = Math.min(left_3, i);
            } else if (x == 1) {
                right_1 = i;
            } else if (x == 2) {
                left_2 = Math.min(left_2, i);
                right_2 = i;
            }
        }

        if (right_1 > left_3) {
            return -1;
        }

        int ans = 0;
        if (left_3 < right_2) {
            for (int i = left_3; i < right_2; i++) {
                ans += locked[i];
            }
        }
        if (left_2 < right_1) {
            for (int i = left_2; i < right_1; i++) {
                ans += locked[i];
            }
        }
        return ans;
    }
}
/*
$3431. 对数字排序的最小解锁下标
https://leetcode.cn/problems/minimum-unlocked-indices-to-sort-nums/description/

给定一个仅包含 1、2、3 的整数的数组 nums，以及一个相同大小的 二进制 数组 locked。
当满足 nums[i] - nums[i + 1] == 1 且 locked[i] == 0时，则允许交换下标 i 和 i + 1 处的元素；如果可以通过交换相邻元素将 nums 升序排序，我们认为 nums 是 可排序的。
你可以进行若干次操作，每次操作可以将 locked[i] 设置为 0，从而解锁下标 i。
返回使 nums 满足 可排序的 所需 最小 操作次数。如果不可能使 nums 可排序，返回 -1。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 3
locked.length == nums.length
0 <= locked[i] <= 1

[最左边的2，最右边的1) + [最左边的3，最右边的2) 区间内1的个数
https://leetcode.cn/problems/minimum-unlocked-indices-to-sort-nums/solutions/3056014/qian-zhui-he-by-13126731116-hedb/
 */