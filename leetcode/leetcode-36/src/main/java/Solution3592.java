import java.util.ArrayList;
import java.util.List;

public class Solution3592 {
    public List<Integer> findCoins(int[] numWays) {
        int n = numWays.length;
        long[] A = new long[n + 1];
        A[0] = 1;
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            long target = numWays[i - 1];
            if (A[i] > target) {
                return new ArrayList<>();
            }
            if (A[i] < target) {
                if (target - A[i] != 1) {
                    return new ArrayList<>();
                }
                ans.add(i);
                for (int j = i; j <= n; j++) {
                    A[j] += A[j - i];
                }
            }
        }
        return ans;
    }
}
/*
3592. 硬币面值还原
https://leetcode.cn/problems/inverse-coin-change/description/

第 455 场周赛 T2。

给你一个 从 1 开始计数 的整数数组 numWays，其中 numWays[i] 表示使用某些 固定 面值的硬币（每种面值可以使用无限次）凑出总金额 i 的方法数。每种面值都是一个 正整数 ，并且其值 最多 为 numWays.length。
然而，具体的硬币面值已经 丢失 。你的任务是还原出可能生成这个 numWays 数组的面值集合。
返回一个按从小到大顺序排列的数组，其中包含所有可能的 唯一 整数面值。
如果不存在这样的集合，返回一个 空 数组。
提示：
1 <= numWays.length <= 100
0 <= numWays[i] <= 2 * 10^8

完全背包 逆运算。
时间复杂度 O(n^2)。
相似题目: 518. 零钱兑换 II
https://leetcode.cn/problems/coin-change-ii/description/
 */