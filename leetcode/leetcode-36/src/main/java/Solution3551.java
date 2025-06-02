import java.util.Arrays;
import java.util.Comparator;

public class Solution3551 {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] b = new int[n]; // 数位和
        for (int i = 0; i < n; i++) {
            b[i] = digitSum(nums[i]);
        }

        // 置换环：对于每个环，交换次数为环的大小减一。
        Integer[] ids = new Integer[n]; // 将 a 离散化
        for (int i = 0; i < n; i++) ids[i] = i;
        // 如果两个数字的数位和相等，则较小的数字排在前面。
        Arrays.sort(ids, Comparator.comparingInt(o -> b[(int) o])
                .thenComparingInt(o -> nums[(int) o]));

        int ans = n;
        boolean[] vis = new boolean[n];
        for (Integer v : ids) {
            if (vis[v]) continue;
            while (!vis[v]) {
                vis[v] = true;
                v = ids[v];
            }
            ans -= 1;
        }
        return ans;
    }

    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
/*
3551. 数位和排序需要的最小交换次数
https://leetcode.cn/problems/minimum-swaps-to-sort-by-digit-sum/description/

第 450 场周赛 T2。

给你一个由 互不相同 的正整数组成的数组 nums，需要根据每个数字的数位和（即每一位数字相加求和）按 升序 对数组进行排序。如果两个数字的数位和相等，则较小的数字排在前面。
返回将 nums 排列为上述排序顺序所需的 最小 交换次数。
一次 交换 定义为交换数组中两个不同位置的值。
提示:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
nums 由 互不相同 的正整数组成。

置换环。
相似题目: 2471. 逐层排序二叉树所需的最少操作数目
https://leetcode.cn/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/
 */