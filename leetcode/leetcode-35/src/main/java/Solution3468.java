public class Solution3468 {
    public int countArrays(int[] original, int[][] bounds) {
        int n = original.length;
        int minUp = Integer.MAX_VALUE;
        int minDown = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int ui = bounds[i][0], vi = bounds[i][1];
            int up = vi - original[i]; // 上移多少
            int down = original[i] - ui; // 下移多少
            minUp = Math.min(minUp, up);
            minDown = Math.min(minDown, down);
        }
        return Math.max(0, minUp + minDown + 1);
    }
}
/*
3468. 可行数组的数目
https://leetcode.cn/problems/find-the-number-of-copy-arrays/description/

第 151 场双周赛 T2。

给你一个长度为 n 的数组 original 和一个长度为 n x 2 的二维数组 bounds，其中 bounds[i] = [ui, vi]。
你需要找到长度为 n 且满足以下条件的 可能的 数组 copy 的数量：
1.对于 1 <= i <= n - 1 ，都有 (copy[i] - copy[i - 1]) == (original[i] - original[i - 1]) 。
2.对于 0 <= i <= n - 1 ，都有 ui <= copy[i] <= vi 。
返回满足这些条件的数组数目。
提示：
2 <= n == original.length <= 10^5
1 <= original[i] <= 10^9
bounds.length == n
bounds[i].length == 2
1 <= bounds[i][0] <= bounds[i][1] <= 10^9

移项得 copy[i]=copy[0]+original[i]−original[0]
求这 n 个 copy[0] 的交集。
时间复杂度 O(n)。
 */