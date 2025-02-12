import java.util.Arrays;
import java.util.Comparator;

public class Solution3413 {
    public long maximumCoins(int[][] coins, int k) {
        long ans = maximumWhiteTiles(coins, k);
        int mx = (int) 1e9;
        for (int[] coin : coins) {
            int l = coin[0], r = coin[1];
            coin[0] = mx - r;
            coin[1] = mx - l;
        }
        ans = Math.max(ans, maximumWhiteTiles(coins, k));
        return ans;
    }

    private long maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int n = tiles.length;
        Arrays.sort(tiles, Comparator.comparingInt(o -> o[0]));
        long ans = 0;
        long cover = 0;
        int l = 0, r = 0;
        while (r < n) {
            long tl = tiles[r][0], tr = tiles[r][1], c = tiles[r][2];
            cover += (tr - tl + 1) * c;

            while (tiles[l][1] + carpetLen - 1 < tr) {
                cover -= (tiles[l][1] - tiles[l][0] + 1L) * tiles[l][2];
                l++;
            }
            long unCover = Math.max(0, (tr - carpetLen + 1 - tiles[l][0]) * tiles[l][2]);
            ans = Math.max(ans, cover - unCover);
            r++;
        }
        return ans;
    }
}
/*
3413. 收集连续 K 个袋子可以获得的最多硬币数量
https://leetcode.cn/problems/maximum-coins-from-k-consecutive-bags/description/

第 431 场周赛 T3。

在一条数轴上有无限多个袋子，每个坐标对应一个袋子。其中一些袋子里装有硬币。
给你一个二维数组 coins，其中 coins[i] = [li, ri, ci] 表示从坐标 li 到 ri 的每个袋子中都有 ci 枚硬币。
数组 coins 中的区间互不重叠。
另给你一个整数 k。
返回通过收集连续 k 个袋子可以获得的 最多 硬币数量。
提示：
1 <= coins.length <= 10^5
1 <= k <= 10^9
coins[i] == [li, ri, ci]
1 <= li <= ri <= 10^9
1 <= ci <= 1000
给定的区间互不重叠。

线段树会 TLE。只能滑动窗口。
相似题目: 2271. 毯子覆盖的最多白色砖块数
https://leetcode.cn/problems/maximum-white-tiles-covered-by-a-carpet/
rating 2377 (clist.by)
 */