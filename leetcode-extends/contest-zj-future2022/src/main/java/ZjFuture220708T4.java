public class ZjFuture220708T4 {
    public int minTransfers(int[][] distributions) {
        int n = 12;

        int[] cnt = new int[n];
        for (int[] distribution : distributions) {
            cnt[distribution[0]] -= distribution[2];
            cnt[distribution[1]] += distribution[2];
        }

        int[] dp = new int[1 << n];
        for (int state = 1; state < (1 << n); state++) {
            int sum = 0;
            for (int k = 0; k < n; k++) {
                if (((state >> k) & 1) == 1) {
                    sum += cnt[k];
                }

                if (sum > 0) {
                    dp[state] = Integer.MAX_VALUE / 2;
                } else {
                    dp[state] = Integer.bitCount(state) - 1;
                    for (int subState = state; subState > 0; subState = (subState - 1) & state) {
                        dp[state] = Math.min(dp[state], dp[state - subState] + dp[subState]);
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}
/*
zj-future04. 门店商品调配
https://leetcode.cn/contest/zj-future2022/problems/NBCXIp/

某连锁店开设了若干门店，门店间允许进行商品借调以应对暂时性的短缺。本月商品借调的情况记于数组 distributions，
其中 distributions[i] = [from,to,num]，表示从 from 门店调配了 num 件商品给 to 门店。
若要使得每一个门店最终借出和借入的商品数量相同，请问至少还需要进行多少次商品调配。
注意：一次商品调配以三元组 [from, to, num] 表示，并有 from ≠ to 且 num > 0。
示例 1：
输入：distributions = [[0,1,5],[1,2,10],[2,0,5],[2,1,1]]
输出：1
解释：
商店 0 给商店 1 五件商品；
商店 1 给商店 2 十件商品；
商店 2 给商店 0 五件商品；
商店 2 给商店 1 一件商品。
此时商店 1 少了 4 件商品，商店 2 多了 4 件商品，
因此仅需一次商品调配，商店 2 给商店 1 四件商品，即可满足每个门店借出和借入商品数量相同：
商店 0 借出和借入的商品数量均为 5；
商店 1 借出和借入的商品数量均为 10；
商店 2 借出和借入的商品数量均为 10。
示例 2：
输入：distributions = [[0,1,5],[1,4,5],[4,0,5]]
输出：0
解释：
此时各商店借入和借出的商品数量均相等，无需额外的商品调配。
提示：
1 <= distributions.length <= 8
distributions[i].length == 3
0 <= fromi, toi < 12
fromi != toi
1 <= numi <= 100

同: $465. 最优账单平衡
https://leetcode.cn/problems/optimal-account-balancing/
 */