public class Solution3861 {
    public int minimumIndex(int[] capacity, int itemSize) {
        int n = capacity.length;
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < n; i++) {
            if (capacity[i] < itemSize) continue;
            if (min > capacity[i]) {
                min = capacity[i];
                minIdx = i;
            }
        }
        return minIdx;
    }
}
/*
3861. 容量最小的箱子
https://leetcode.cn/problems/minimum-capacity-box/description/

第 492 场周赛 T1。

给你一个整数数组 capacity，其中 capacity[i] 表示第 i 个箱子的容量，以及一个整数 itemSize，表示一个物品的大小。
如果第 i 个箱子的容量满足 capacity[i] >= itemSize，那么该箱子可以存放该物品。
要求返回可以存放该物品的容量 最小 的箱子的下标。如果有多个这样的箱子，返回下标 最小 的一个。
如果没有任何箱子可以存放该物品，则返回 -1。
提示：
1 <= capacity.length <= 100
1 <= capacity[i] <= 100
1 <= itemSize <= 100

中国时间 2026-03-08 周日 10:30
佛山。
遍历。
时间复杂度 O(n)。
 */