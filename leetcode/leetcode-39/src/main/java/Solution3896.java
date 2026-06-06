public class Solution3896 {
    static final int MAX_N = (int) 2e5;
    static boolean[] np;

    static {
        np = new boolean[MAX_N + 1];
        np[1] = true;
        for (int i = 2; i * i <= MAX_N; i++) {
            if (np[i]) continue;
            for (int j = i * i; j <= MAX_N; j += i) np[j] = true;
        }
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        int mx = 0;
        for (int num : nums) {
            if (num > mx) mx = num;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (i % 2 == 0) {
                int cur = val;
                while (cur <= MAX_N && np[cur]) {
                    cur++;
                }
                ans += cur - val;
            } else {
                if (np[val]) {
                    continue;
                }
                int cur = val + 1;
                while (cur <= MAX_N && !np[cur]) {
                    cur++;
                }
                ans += cur - val;
            }
        }
        return ans;
    }
}
/*
3896. 将数组转换为交替质数数组的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-transform-array-into-alternating-prime/description/

第 180 场双周赛 T3。

给你一个整数数组 nums。
如果满足以下条件，则认为数组是 交替质数 数组：
- 偶数 下标（从 0 开始）处的元素是 质数。
- 奇数 下标处的元素是 非质数。
在一次操作中，你可以将任何元素 增加 1。
返回将 nums 转换为 交替质数 数组所需的 最少 操作次数。
质数 是指大于 1 且仅有两个因数（1 和其本身）的自然数。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

筛质数。
https://chat.deepseek.com/a/chat/s/e785d25b-51fe-4e8d-9ce7-b2f4b7ad06d6
时间复杂度 O(nG)，其中 n 是 nums 的长度，G≤72 是本题数据范围下的最大质数间隔。
 */