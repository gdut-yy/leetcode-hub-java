import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3629 {
    private static final int MX = (int) (1e6 + 1);
    private static final List<Integer>[] primeFactors = new ArrayList[MX];

    static {
        Arrays.setAll(primeFactors, e -> new ArrayList<>());
        // 预处理每个数的质因子列表，思路同埃氏筛
        for (int i = 2; i < MX; i++) {
            if (primeFactors[i].isEmpty()) { // i 是质数
                for (int j = i; j < MX; j += i) { // i 的倍数有质因子 i
                    primeFactors[j].add(i);
                }
            }
        }
    }

    public int minJumps(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int p : primeFactors[nums[i]]) {
                // 对于质数 p，可以跳到下标 i
                groups.computeIfAbsent(p, e -> new ArrayList<>()).add(i);
            }
        }

        int ans = 0;
        boolean[] vis = new boolean[n];
        vis[0] = true;
        List<Integer> q = List.of(0);

        while (true) {
            List<Integer> tmp = q;
            q = new ArrayList<>();
            for (int i : tmp) {
                if (i == n - 1) {
                    return ans;
                }
                List<Integer> idx = groups.computeIfAbsent(nums[i], e -> new ArrayList<>());
                idx.add(i + 1);
                if (i > 0) {
                    idx.add(i - 1);
                }
                for (int j : idx) { // 可以从 i 跳到 j
                    if (!vis[j]) {
                        vis[j] = true;
                        q.add(j);
                    }
                }
                idx.clear(); // 避免重复访问下标列表
            }
            ans++;
        }
    }
}
/*
3629. 通过质数传送到达终点的最少跳跃次数
https://leetcode.cn/problems/minimum-jumps-to-reach-end-via-prime-teleportation/description/

第 460 场周赛 T3。

给你一个长度为 n 的整数数组 nums。
你从下标 0 开始，目标是到达下标 n - 1。
在任何下标 i 处，你可以执行以下操作之一：
- 移动到相邻格子：跳到下标 i + 1 或 i - 1，如果该下标在边界内。
- 质数传送：如果 nums[i] 是一个质数 p，你可以立即跳到任何满足 nums[j] % p == 0 的下标 j 处，且下标 j != i 。
返回到达下标 n - 1 所需的 最少 跳跃次数。
质数 是一个大于 1 的自然数，只有两个因子，1 和它本身。
提示:
1 <= n == nums.length <= 10^5
1 <= nums[i] <= 10^6

两种方法：正向 BFS / 逆向 BFS
https://leetcode.cn/problems/minimum-jumps-to-reach-end-via-prime-teleportation/solutions/3734792/bfspythonjavacgo-by-endlesscheng-bu60/
时间复杂度 O(nlogU)。其中 n 是 nums 的长度 U=max(nums)
rating 2148 (clist.by)
 */