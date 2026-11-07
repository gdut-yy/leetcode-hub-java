public class Solution4099 {
    public int minOperations(int[] nums, int[] locked, int k) {
        int n = nums.length;
        BIT t = new BIT(n);
        int ans = 0;
        for (int i = 0; i < n; ) {
            if (nums[i] == i + 1) { // nums[i] 已在正确位置上
                i++;
                continue;
            }
            int mx = -1;
            for (; i < n && mx != i; i++) {
                if (locked[i] > 0) {
                    if (k == 0) { // 无法解锁
                        return -1;
                    }
                    k--;
                    ans++;
                }
                int x = nums[i];
                ans += t.query(x, n); // x 与其左侧元素的逆序对个数
                t.add(x, 1);
                mx = Math.max(mx, x);
            }
        }
        return ans;
    }

    static class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int pos, int val) {
            for (; pos <= n; pos += lb(pos)) tree[pos] += val;
        }

        int pre(int pos) {
            int ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
            return ret;
        }

        int query(int l, int r) {
            return pre(r) - pre(l - 1);
        }
    }
}
/*
4099. 将锁定数组排序的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-sort-with-locked-indices/description/

第 526 场周赛 T3。

给你一个长度为 n 的整数数组 nums，其中 nums 是范围 [1, n] 内整数的一个 排列。
同时给你一个长度为 n 的 二进制 数组 locked 和一个整数 k。
- locked[i] = 1 表示下标 i 已锁定。
- locked[i] = 0 表示下标 i 已解锁。
你可以按 任意顺序 执行以下操作：
- 交换：选择一个下标 i，需满足下标 i 和 i + 1 当前都处于解锁状态，然后交换 nums[i] 和 nums[i + 1]。
- 解锁：选择一个下标 i，满足 locked[i] = 1，并通过将 locked[i] = 0 来 永久 解锁它。
你可以执行任意次数的交换操作，但 最多 只能执行 k 次解锁操作。
返回将 nums 排序为 严格递增 顺序所需的 最小总操作次数 。如果不可能，则返回 -1。
示例 1：
输入： nums = [2,1,3,4], locked = [0,1,0,1], k = 1
输出： 2
示例 2：
输入： nums = [3,1,2], locked = [1,0,1], k = 2
输出： 4
示例 3：
输入： nums = [2,3,1], locked = [1,0,0], k = 0
输出： -1
提示：
1 <= n == nums.length == locked.length <= 2000
1 <= nums[i] <= n
0 <= locked[i] <= 1
nums 是范围 [1, n] 内整数的一个排列。
0 <= k <= n

分组循环+逆序对。
时间复杂度 O(nlogn)。
 */