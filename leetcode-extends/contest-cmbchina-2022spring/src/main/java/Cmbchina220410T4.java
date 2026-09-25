public class Cmbchina220410T4 {
    public int goShopping(int[] priceA, int[] priceB) {
        int n = priceA.length;
        // 将商品按 priceB 降序排序，方便处理商店B的“免最低价”优惠
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) index[i] = i;
        java.util.Arrays.sort(index, (a, b) -> priceB[b] - priceB[a]);

        int[] sortedA = new int[n];
        int[] sortedB = new int[n];
        for (int i = 0; i < n; i++) {
            sortedA[i] = priceA[index[i]];
            sortedB[i] = priceB[index[i]];
        }

        final int INF = Integer.MAX_VALUE / 2;
        int ans = INF;

        // 策略一：在商店A购买不少于3件
        // dp[j][k] 表示当前在A店买了j件（j=0,1,2,3表示>=3），在B店买了k件（k=0,1,2）
        int[][] dp1 = new int[4][3];
        for (int[] row : dp1) java.util.Arrays.fill(row, INF);
        dp1[0][0] = 0;

        for (int i = 0; i < n; i++) {
            int[][] next = new int[4][3];
            for (int[] row : next) java.util.Arrays.fill(row, INF);

            for (int j = 0; j <= 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (dp1[j][k] == INF) continue;

                    // 选择在商店A购买（享受七折）
                    int nj = Math.min(j + 1, 3);
                    int costA = (int) (sortedA[i] * 0.7); // 向下取整
                    next[nj][k] = Math.min(next[nj][k], dp1[j][k] + costA);

                    // 选择在商店B购买
                    int nk = (k + 1) % 3;
                    int costB = (k == 2) ? 0 : sortedB[i]; // 第三件免费
                    next[j][nk] = Math.min(next[j][nk], dp1[j][k] + costB);
                }
            }
            dp1 = next;
        }
        // 只考虑在A店买了至少3件的合法状态
        for (int k = 0; k < 3; k++) {
            ans = Math.min(ans, dp1[3][k]);
        }

        // 策略二：在商店A购买少于3件
        int[][] dp2 = new int[3][3]; // j 只能取 0,1,2
        for (int[] row : dp2) java.util.Arrays.fill(row, INF);
        dp2[0][0] = 0;

        for (int i = 0; i < n; i++) {
            int[][] next = new int[3][3];
            for (int[] row : next) java.util.Arrays.fill(row, INF);

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (dp2[j][k] == INF) continue;

                    // 选择在商店A购买（无优惠）
                    if (j + 1 < 3) {
                        next[j + 1][k] = Math.min(next[j + 1][k], dp2[j][k] + sortedA[i]);
                    }

                    // 选择在商店B购买
                    int nk = (k + 1) % 3;
                    int costB = (k == 2) ? 0 : sortedB[i];
                    next[j][nk] = Math.min(next[j][nk], dp2[j][k] + costB);
                }
            }
            dp2 = next;
        }
        // 只考虑在A店买了少于3件的合法状态
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                ans = Math.min(ans, dp2[j][k]);
            }
        }

        return ans;
    }
}
/*
招商银行-04. 商店促销活动
https://leetcode.cn/contest/cmbchina-2022spring/problems/OK3hsO/

招商银行为持卡人提供各方面消费的优惠政策。随着促销季的到来，两家商店分别为招行卡客户推出了不同的促销活动：
- 商店 A 的优惠活动：购买商品满三件及以上商品可以打七折（向下取整），不满三件则无任何优惠
- 商店 B 的优惠活动：每购买三件商品，可以免去其中价格最低的一件商品的价格
商店 A 和商店 B 均有售卖编号 0 ～ N-1 的商品，priceA[i] 表示编号 i 的商品在商店中 A 的价格， priceB[i] 表示编号 i 的商品在商店中 B 的价格。
假如需要编号 0 ～ N-1 的商品各买一件，请你求出最少的花费。
注意：
每件商品必须买，且只能买一件。
示例 1：
输入：
priceA = [1,2,5]
priceB = [2,2,2]
输出: 4
解释：
在商店 B 购买全部三件商品，花费最少为 4。
示例 2：
输入：
priceA = [1,6,1]
priceB = [2,2,6]
输出: 4
解释：
在商店 A 购买第一和第三件商品，在商店 B 购买第二件商品。
示例 3：
输入：
priceA = [3,13,5,12]
priceB = [28,12,20,7]
输出: 21
解释：
在商店 A 购买 [3,13,5]，花费了 14
在商店 B 购买 [7]， 花费了 7。
因此最少花费 21
提示：
1 <= priceA.length = priceB.length <= 10^5
1 <= priceA[i], priceB[i] <= 10^4
 */