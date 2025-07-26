import java.util.Arrays;

public class Solution1449 {
    public String largestNumber(int[] cost, int target) {
        int[] f = new int[target + 1];
        Arrays.fill(f, Integer.MIN_VALUE);
        f[0] = 0;
        for (int i = 1; i <= 9; i++) {
            int u = cost[i - 1];
            for (int j = u; j <= target; j++) {
                f[j] = Math.max(f[j], f[j - u] + 1);
            }
        }
        if (f[target] < 0) return "0";
        StringBuilder ans = new StringBuilder();
        for (int i = 9, j = target; i >= 1; i--) {
            int u = cost[i - 1];
            while (j >= u && f[j] == f[j - u] + 1) {
                ans.append(i);
                j -= u;
            }
        }
        return ans.toString();
    }
}
/*
1449. 数位成本和为目标值的最大数字
https://leetcode.cn/problems/form-largest-integer-with-digits-that-add-up-to-target/description/

给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数：
- 给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。
- 总成本必须恰好等于 target 。
- 添加的数位中没有数字 0 。
由于答案可能会很大，请你以字符串形式返回。
如果按照上述要求无法得到任何整数，请你返回 "0" 。
提示：
cost.length == 9
1 <= cost[i] <= 5000
1 <= target <= 5000

问题转换为：有若干物品，求给定费用的前提下，花光所有费用所能选择的最大价值（物品个数）为多少。
https://leetcode.cn/problems/form-largest-integer-with-digits-that-add-up-to-target/solutions/824611/gong-shui-san-xie-fen-liang-bu-kao-lu-we-uy4y/
时间复杂度 O(nt)。
 */
