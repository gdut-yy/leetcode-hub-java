import java.util.Arrays;

public class Cnunionpay220313T3 {
    public int maxInvestment(int[] product, int limit) {
        Arrays.sort(product);

        long sum = 0;
        long mod = 1000000007;
        int len = product.length;
        for (int i = len - 1; i >= 0; i--) {
            long width = len - i;
            long height = (i - 1 >= 0) ? (product[i] - product[i - 1]) : product[i];
            if (product[i] > 0) {
                long costHeight = Math.min(height, limit / width);
                if (costHeight > 0) {
                    long total = (product[i] + product[i] - costHeight + 1) * costHeight / 2 * width % mod;
                    sum = (sum + total) % mod;
                    limit -= costHeight * width;
                    product[i] -= costHeight;
                }
                if (limit / width < 1) {
                    sum = (sum + (long) product[i] * limit % mod) % mod;
                    return (int) sum;
                }
            } else {
                return (int) sum;
            }
        }
        return (int) sum;
    }
}
/*
银联-03. 理财产品
https://leetcode-cn.com/contest/cnunionpay-2022spring/problems/I4mOGz/

某公司计划推出一批投资项目。 product[i] = price 表示第 i 个理财项目的投资金额 price 。客户在按需投资时，需要遵循以下规则：
- 客户在首次对项目 product[i] 投资时，需要投入金额 price
- 对已完成首次投资的项目 product[i] 可继续追加投入，但追加投入的金额需小于上一次对该项目的投入(追加投入为大于 0 的整数)
- 为控制市场稳定，每人交易次数不得大于 limit。(首次投资和追加投入均记作 1 次交易)
若对所有理财项目中最多进行 limit 次交易，使得投入金额总和最大，请返回这个最大值的总和。
注意：
- 答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
提示：
1 <= product.length <= 10^5
1 <= product[i] <= 10^7
1 <= limit <= 10^9

直接模拟显然会 TLE。可排序后 贪心 解决。
 */