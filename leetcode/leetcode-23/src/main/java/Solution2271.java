import java.util.Arrays;
import java.util.Comparator;

public class Solution2271 {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int n = tiles.length;
        Arrays.sort(tiles, Comparator.comparingInt(o -> o[0]));
        int ans = 0;
        int cover = 0;
        int l = 0, r = 0;
        while (r < n) {
            int tl = tiles[r][0], tr = tiles[r][1];
            cover += tr - tl + 1;

            while (tiles[l][1] + carpetLen - 1 < tr) {
                cover -= tiles[l][1] - tiles[l][0] + 1;
                l++;
            }
            int unCover = Math.max(0, (tr - carpetLen + 1) - tiles[l][0]);
            ans = Math.max(ans, cover - unCover);
            r++;
        }
        return ans;
    }
}
/*
2271. 毯子覆盖的最多白色砖块数
https://leetcode.cn/problems/maximum-white-tiles-covered-by-a-carpet/

第 78 场双周赛 T3。

给你一个二维整数数组 tiles ，其中 tiles[i] = [li, ri] ，表示所有在 li <= j <= ri 之间的每个瓷砖位置 j 都被涂成了白色。
同时给你一个整数 carpetLen ，表示可以放在 任何位置 的一块毯子。
请你返回使用这块毯子，最多 可以盖住多少块瓷砖。
提示：
1 <= tiles.length <= 5 * 10^4
tiles[i].length == 2
1 <= li <= ri <= 10^9
1 <= carpetLen <= 10^9
tiles 互相 不会重叠 。

滑动窗口。树状数组 TLE。
相似题目: 3413. 收集连续 K 个袋子可以获得的最多硬币数量
https://leetcode.cn/problems/maximum-coins-from-k-consecutive-bags/description/
 */