import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Solution3695 {
    public long maxAlternatingSum(int[] nums, int[][] swaps) {
        int n = nums.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : swaps) {
            int u = p[0], v = p[1];
            g[u].add(v);
            g[v].add(u);
        }

        boolean[] vis = new boolean[n];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                List<Integer> component = new ArrayList<>();
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                vis[i] = true;
                component.add(i);
                while (!q.isEmpty()) {
                    int x = q.remove();
                    for (int y : g[x]) {
                        if (!vis[y]) {
                            vis[y] = true;
                            component.add(y);
                            q.add(y);
                        }
                    }
                }
                int evenCount = 0;
                List<Integer> values = new ArrayList<>();
                for (int idx : component) {
                    if (idx % 2 == 0) evenCount++;
                    values.add(nums[idx]);
                }
                values.sort(Collections.reverseOrder());

                long sumEven = 0;
                for (int j = 0; j < evenCount; j++) {
                    sumEven += values.get(j);
                }
                long sumOdd = 0;
                for (int j = evenCount; j < values.size(); j++) {
                    sumOdd += values.get(j);
                }
                ans += sumEven - sumOdd;
            }
        }
        return ans;
    }
}
/*
3695. 交换元素后的最大交替和
https://leetcode.cn/problems/maximize-alternating-sum-using-swaps/description/

第 166 场双周赛 T4。

给你一个整数数组 nums。
你希望最大化 nums 的 交替和：将偶数下标的元素 相加 并 减去 奇数索引的元素获得的值。即 nums[0] - nums[1] + nums[2] - nums[3]...
同时给你一个二维整数数组 swaps，其中 swaps[i] = [pi, qi]。对于 swaps 中的每对 [pi, qi]，你可以交换索引 pi 和 qi 处的元素。这些交换可以进行任意次数和任意顺序。
返回 nums 可能的最大 交替和。
提示:
2 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
0 <= swaps.length <= 10^5
swaps[i] = [pi, qi]
0 <= pi < qi <= nums.length - 1
[pi, qi] != [pj, qj]

贪心。DFS 连通块。
时间复杂度 O(nlogn)。
 */