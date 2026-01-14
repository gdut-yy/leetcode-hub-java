public class Solution3776 {
    public long minMoves(int[] balance) {
        long sum = 0;
        int negIdx = -1;
        for (int i = 0; i < balance.length; i++) {
            int x = balance[i];
            sum += x;
            if (x < 0) {
                negIdx = i;
            }
        }
        // 总和必须非负
        if (sum < 0) return -1;
        // 没有负数，无需操作
        if (negIdx == -1) return 0;

        int n = balance.length;
        int need = -balance[negIdx];
        long ans = 0;
        for (int dis = 1; ; dis++) { // 把与 negIdx 相距 dis 的数移到 negIdx
            int s = balance[(negIdx - dis + n) % n] + balance[(negIdx + dis) % n];
            if (s >= need) {
                ans += (long) need * dis; // need 个 1 移动 dis 次
                return ans;
            }
            ans += (long) s * dis; // s 个 1 移动 dis 次
            need -= s;
        }
    }
}
/*
3776. 使循环数组余额非负的最少移动次数
https://leetcode.cn/problems/minimum-moves-to-balance-circular-array/description/

第 480 场周赛 T3。

给你一个长度为 n 的 环形 数组 balance，其中 balance[i] 是第 i 个人的净余额。
在一次移动中，一个人可以将 正好 1 个单位的余额转移给他的左邻居或右邻居。
返回使每个人都拥有 非负 余额所需的 最小 移动次数。如果无法实现，则返回 -1。
注意：输入保证初始时 至多 有一个下标具有 负 余额。
提示：
1 <= n == balance.length <= 10^5
-10^9 <= balance[i] <= 10^9
balance 中初始至多有一个负值。

贪心，从近到远
时间复杂度 O(n)。
 */