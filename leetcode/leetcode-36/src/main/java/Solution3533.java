import java.util.Arrays;

public class Solution3533 {
    private int[] nums, pow10, ans;
    private int k;
    private boolean[][] vis;

    public int[] concatenatedDivisibility(int[] nums, int k) {
        Arrays.sort(nums);
        this.nums = nums;
        this.k = k;
        int n = nums.length;
        pow10 = new int[n];
        for (int i = 0; i < n; i++) {
            pow10[i] = (int) Math.pow(10, Integer.toString(nums[i]).length());
        }

        ans = new int[n];
        vis = new boolean[1 << n][k];
        if (!dfs((1 << n) - 1, 0)) {
            return new int[]{};
        }
        return ans;
    }

    // S 表示剩余未填（没有选过的）数字的下标
    // x 表示当前拼接的数字模 k 的结果
    private boolean dfs(int s, int x) {
        if (s == 0) {
            return x == 0;
        }
        if (vis[s][x]) {
            return false;
        }
        vis[s][x] = true;
        // 枚举在 s 中的下标 i
        for (int i = 0; i < nums.length; i++) {
            if ((s & (1 << i)) > 0 && dfs(s ^ (1 << i), (x * pow10[i] + nums[i]) % k)) {
                ans[nums.length - Integer.bitCount(s)] = nums[i];
                return true;
            }
        }
        return false;
    }
}
/*
3533. 判断连接可整除性
https://leetcode.cn/problems/concatenated-divisibility/description/

第 447 场周赛 T3。

给你一个正整数数组 nums 和一个正整数 k。
当 nums 的一个 排列 中的所有数字，按照排列顺序 连接其十进制表示 后形成的数可以 被 k  整除时，我们称该排列形成了一个 可整除连接 。
返回能够形成 可整除连接 且 字典序 最小 的排列（按整数列表的形式表示）。如果不存在这样的排列，返回一个空列表。
提示：
1 <= nums.length <= 13
1 <= nums[i] <= 10^5
1 <= k <= 100

全排列暴搜
https://leetcode.cn/problems/concatenated-divisibility/solutions/3663246/quan-pai-lie-bao-sou-pythonjavacgo-by-en-l4zv/
时间复杂度 O(nk * 2^n)。
rating 2242 (clist.by)
 */