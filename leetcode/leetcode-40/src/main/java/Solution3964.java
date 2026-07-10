public class Solution3964 {
    public int minLights(int[] lights) {
        int n = lights.length;
        int[] diff = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (lights[i] > 0) {
                int l = Math.max(0, i - lights[i]);
                int r = Math.min(n - 1, i + lights[i]);
                diff[l]++;
                diff[r + 1]--;
            }
        }
        int ans = 0, cov = 0, i = 0;
        while (i < n) {
            cov += diff[i];
            if (cov > 0) {
                i++;
            } else {
                ans++;
                i++;
                int end = Math.min(i + 2, n);
                while (i < end) {
                    cov += diff[i];
                    i++;
                }
            }
        }
        return ans;
    }
}
/*
3964. 照亮道路的最少灯泡数
https://leetcode.cn/problems/minimum-lights-to-illuminate-a-road/description/

第 185 场双周赛 T2。

给你一个长度为 n 的整数数组 lights，表示一条路上从 0 到 n - 1 有 n 个位置。
对于每个位置 i：
- 如果 lights[i] = v，其中 v > 0，则在位置 i 有一个正常工作的灯泡，它 照亮 从 max(0, i - v) 到 min(n - 1, i + v)（包含边界）的每个位置。
- 如果 lights[i] = 0，则在位置 i 没有正常工作的灯泡。
如果一个位置被 至少 一个正常工作的灯泡照亮，则该位置是 可见的 。
你可以在 任意 位置安装 额外的 灯泡。每个安装在位置 j 的额外灯泡将照亮从 max(0, j - 1) 到 min(n - 1, j + 1)（包含边界）的位置。
返回使路上 每个 位置都可见所需安装的最少额外灯泡数量。
提示：
1 <= n == lights.length <= 10^5
0 <= lights[i] <= n

差分数组。
时间复杂度 O(n)。
 */