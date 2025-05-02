public class Solution3516 {
    public int findClosest(int x, int y, int z) {
        int a = Math.abs(x - z);
        int b = Math.abs(y - z);
        if (a == b) return 0;
        return a < b ? 1 : 2;
    }
}
/*
3516. 找到最近的人
https://leetcode.cn/problems/find-closest-person/description/

第 445 场周赛 T1。

给你三个整数 x、y 和 z，表示数轴上三个人的位置：
- x 是第 1 个人的位置。
- y 是第 2 个人的位置。
- z 是第 3 个人的位置，第 3 个人 不会移动 。
第 1 个人和第 2 个人以 相同 的速度向第 3 个人移动。
判断谁会 先 到达第 3 个人的位置：
- 果第 1 个人先到达，返回 1 。
- 果第 2 个人先到达，返回 2 。
- 果两个人同时到达，返回 0 。
根据上述规则返回结果。
提示：
1 <= x, y, z <= 100

中国时间 2025-04-13 周日 10:30
广州·中肿。前1天。
计算绝对值
时间复杂度 O(1)。
 */