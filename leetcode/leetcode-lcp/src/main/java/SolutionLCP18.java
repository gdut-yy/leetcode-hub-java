import java.util.Arrays;

public class SolutionLCP18 {
    private static final int MOD = (int) (1e9 + 7);

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int len = drinks.length;
        Arrays.sort(staple);
        Arrays.sort(drinks);

        long res = 0L;
        for (int sta : staple) {
            int max = x - sta;

            // 二分
            int left = 0;
            int right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (max < drinks[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res += left;
            res %= MOD;
        }
        return (int) res;
    }
}
/*
LCP 18. 早餐组合
https://leetcode.cn/problems/2vYnGI/

小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，一维整型数组 drinks 中记录了每种饮料的价格。
小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。请返回小扣共有多少种购买方案。
注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
提示：
1 <= staple.length <= 10^5
1 <= drinks.length <= 10^5
1 <= staple[i],drinks[i] <= 10^5
1 <= x <= 2*10^5

排序 + 二分
时间复杂度 O(nlogn)
 */