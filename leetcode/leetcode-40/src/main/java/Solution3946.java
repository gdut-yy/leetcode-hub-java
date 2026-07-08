import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3946 {
    public int maximumSaleItems(int[][] items, int budget) {
        int maxFactor = 0;
        for (int[] it : items) {
            if (it[0] > maxFactor) maxFactor = it[0];
        }
        int[] freq = new int[maxFactor + 1];
        for (int[] it : items) {
            freq[it[0]]++;
        }

        int[] total = new int[maxFactor + 1];
        for (int f = 1; f <= maxFactor; f++) {
            if (freq[f] > 0) {
                for (int m = f; m <= maxFactor; m += f) {
                    total[f] += freq[m];
                }
            }
        }

        List<int[]> affordable = new ArrayList<>();
        for (int[] it : items) {
            int price = it[1];
            if (price <= budget) {
                int profit = total[it[0]];
                affordable.add(new int[]{profit, price});
            }
        }
        if (affordable.isEmpty()) return 0;

        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int[] it : affordable) {
            groups.computeIfAbsent(it[1], k -> new ArrayList<>()).add(it[0]);
        }
        List<Integer> prices = new ArrayList<>(groups.keySet());
        prices.sort(Collections.reverseOrder());

        int[] dpNo = new int[budget + 1];
        Arrays.fill(dpNo, -1);
        dpNo[0] = 0;
        int ans = 0;

        for (int p : prices) {
            List<Integer> profits = groups.get(p);
            int[] dp0 = dpNo;
            int[] dp1 = new int[budget + 1];
            Arrays.fill(dp1, -1);
            for (int profit : profits) {
                for (int c = budget; c >= p; c--) {
                    if (dp1[c - p] != -1) {
                        dp1[c] = Math.max(dp1[c], dp1[c - p] + profit);
                    }
                    if (dp0[c - p] != -1) {
                        dp1[c] = Math.max(dp1[c], dp0[c - p] + profit);
                    }
                }
            }
            for (int c = 0; c <= budget; c++) {
                if (dp1[c] != -1) {
                    int extra = (budget - c) / p;
                    ans = Math.max(ans, dp1[c] + extra);
                }
            }
            for (int c = 0; c <= budget; c++) {
                if (dp1[c] != -1) {
                    dpNo[c] = Math.max(dpNo[c], dp1[c]);
                }
            }
        }
        return ans;
    }
}
/*
3946. 购买最多物品数目 I
https://leetcode.cn/problems/maximum-number-of-items-from-sale-i/description/

第 504 场周赛 T2。

给你一个二维整数数组 items，其中 items[i] = [factori, pricei] 表示下标为 i 的物品。同时给你一个整数 budget。
每种物品都有无限个可供购买。你可以购买任意数量的任意物品，但购买物品的总花费最多为 budget。
购买物品后，你可以根据以下规则获得免费的物品：
- 如果你购买了若干个物品 i，所有满足 j != i 且 factori 可以整除 factorj 的物品 j ，你都能 免费 获得一份。
- 重复购买物品 i 不能 再获取额外的免费物品。
- 如果免费物品 j 是通过购买不同种类的物品获得的，那么同一种物品 j 可以被免费获得多次。
返回你在购买物品花费最多为 budget 的前提下，能够获得的 物品最大总数 ，包括购买的物品和免费的物品。
提示：
1 <= items.length <= 1000
items[i] = [factori, pricei]
1 <= factori, pricei <= 1500
1 <= budget <= 1500

0-1 背包 + 枚举优化。
时间复杂度 O(n(n+budget))。
 */