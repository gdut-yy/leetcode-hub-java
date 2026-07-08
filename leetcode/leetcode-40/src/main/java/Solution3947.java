import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution3947 {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] factor = new int[n];
        int[] price = new int[n];
        int maxFactor = 0;
        for (int i = 0; i < n; i++) {
            factor[i] = items[i][0];
            price[i] = items[i][1];
            if (factor[i] > maxFactor) {
                maxFactor = factor[i];
            }
        }

        int[] freq = new int[maxFactor + 1];
        for (int f : factor) {
            freq[f]++;
        }

        int[] sumMultiples = new int[maxFactor + 1];
        for (int f = 1; f <= maxFactor; f++) {
            if (freq[f] == 0) continue;
            for (int m = f; m <= maxFactor; m += f) {
                sumMultiples[f] += freq[m];
            }
        }

        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = sumMultiples[factor[i]] - 1;
        }

        int pMin = Arrays.stream(price).min().orElseThrow();
        List<int[]> goodItems = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (d[i] > 0 && price[i] < 2L * pMin) {
                goodItems.add(new int[]{price[i], d[i]});
            }
        }
        goodItems.sort(Comparator.comparingInt(a -> a[0]));

        long remaining = budget;
        long ans = 0;

        for (int[] item : goodItems) {
            int p = item[0];
            int maxCnt = item[1];
            if (remaining < p) break;
            long take = Math.min(maxCnt, remaining / p);
            ans += 2 * take;
            remaining -= take * p;
        }
        ans += remaining / pMin;
        return (int) ans;
    }
}
/*
3947. 购买最多物品数目 II
https://leetcode.cn/problems/maximum-number-of-items-from-sale-ii/description/

第 504 场周赛 T3。

给你一个二维整数数组 items，其中 items[i] = [factori, pricei] 表示下标为 i 的物品。同时给你一个整数 budget。
每种物品都有无限个可供购买。你可以购买任意数量的任意物品，但购买物品的总花费最多为 budget。
购买物品后，你可以根据以下规则获得免费的物品：
- 购买的每一份物品 i 最多 可以让你获得 一份 免费的其他物品 j。
- 免费物品必须满足 i != j 且 factori 可以整除 factorj。
- 对于每个有序对 (i, j)，无论你购买了多少个物品 i，你从物品 i 的购买中 最多只能一次 免费获得物品 j。
- 如果免费物品 j 是通过购买不同种类的物品获得的，那么同一种物品 j 可以被免费获得多次。
返回你在购买物品花费最多为 budget 的前提下，能够获得的 物品最大总数 ，包括购买的物品和免费的物品。
提示：
1 <= items.length <= 10^5
items[i] = [factori, pricei]
1 <= factori <= items.length
1 <= pricei <= 10^9
1 <= budget <= 10^9

贪心。
时间复杂度 O(nlogn)。
 */