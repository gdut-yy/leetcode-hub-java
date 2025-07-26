public class Solution1739 {
    // O(sqrt(n))
    public int minimumBoxes(int n) {
        int ans = 0;
        int maxN = 0;
        for (int i = 1; maxN + ans + i <= n; i++) {
            ans += i;
            maxN += ans;
        }
        for (int j = 1; maxN < n; j++) {
            ans++;
            maxN += j;
        }
        return ans;
    }

    // O(1)
    public int minimumBoxes2(int n) {
        int x = (int) Math.cbrt(6L * n);
        int ans = x * (x + 1) / 2;
        int maxN = (int) ((long) x * (x + 1) * (x + 2) / 6);
        if (maxN > n) {
            maxN -= ans;
            ans -= x;
        }
        return ans + (int) Math.ceil(Math.sqrt(1 + 8 * (n - maxN))) / 2;
    }
}
/*
1739. 放置盒子
https://leetcode.cn/problems/building-boxes/description/

有一个立方体房间，其长度、宽度和高度都等于 n 个单位。请你在房间里放置 n 个盒子，每个盒子都是一个单位边长的立方体。放置规则如下：
- 你可以把盒子放在地板上的任何地方。
- 如果盒子 x 需要放置在盒子 y 的顶部，那么盒子 y 竖直的四个侧面都 必须 与另一个盒子或墙相邻。
给你一个整数 n ，返回接触地面的盒子的 最少 可能数量。
提示：
1 <= n <= 10^9

找规律 / 数学。
 */