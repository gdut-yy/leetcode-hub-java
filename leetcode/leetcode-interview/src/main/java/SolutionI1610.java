public class SolutionI1610 {
    public int maxAliveYear(int[] birth, int[] death) {
        int n = birth.length;
        // 偏移量，跨度
        int offset = 1900, span = 105;
        int[] diff = new int[span];
        for (int i = 0; i < n; i++) {
            int l = birth[i] - offset, r = death[i] - offset;
            diff[l]++;
            diff[r + 1]--;
        }
        int sumD = 0, max = 0, maxI = 0;
        for (int i = 0; i < span; i++) {
            sumD += diff[i];
            if (max < sumD) {
                max = sumD;
                maxI = i;
            }
        }
        return maxI + offset;
    }
}
/*
面试题 16.10. 生存人数
https://leetcode.cn/problems/living-people-lcci/description/

给定 N 个人的出生年份和死亡年份，第 i 个人的出生年份为 birth[i]，死亡年份为 death[i]，实现一个方法以计算生存人数最多的年份。
你可以假设所有人都出生于 1900 年至 2000 年（含 1900 和 2000 ）之间。如果一个人在某一年的任意时期处于生存状态，那么他应该被纳入那一年的统计中。例如，生于 1908 年、死于 1909 年的人应当被列入 1908 年和 1909 年的计数。
如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
提示：
0 < birth.length == death.length <= 10000
birth[i] <= death[i]

差分思想
时间复杂度 O(n)
 */