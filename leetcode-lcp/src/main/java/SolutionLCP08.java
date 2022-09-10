public class SolutionLCP08 {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int len = increase.length;

        // 一个势力的主要属性有三种，分别是文明等级（C），资源储备（R）以及人口数量（H）。
        // 前缀和
        int[] preSum1 = new int[len + 1];
        int[] preSum2 = new int[len + 1];
        int[] preSum3 = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum1[i + 1] = preSum1[i] + increase[i][0];
            preSum2[i + 1] = preSum2[i] + increase[i][1];
            preSum3[i + 1] = preSum3[i] + increase[i][2];
        }

        int resLen = requirements.length;
        int[] res = new int[resLen];
        for (int i = 0; i < resLen; i++) {
            // 三者取最大值
            int res1 = binarySearchLeftBound(preSum1, requirements[i][0]);
            int res2 = binarySearchLeftBound(preSum2, requirements[i][1]);
            int res3 = binarySearchLeftBound(preSum3, requirements[i][2]);
            int max = Math.max(res1, Math.max(res2, res3));
            res[i] = (max <= len) ? max : -1;
        }
        return res;
    }

    private int binarySearchLeftBound(int[] preSum, int requirement) {
        int left = 0;
        int right = preSum.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (preSum[mid] >= requirement) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
/*
LCP 08. 剧情触发时间
https://leetcode.cn/problems/ju-qing-hong-fa-shi-jian/

在战略游戏中，玩家往往需要发展自己的势力来触发各种新的剧情。
一个势力的主要属性有三种，分别是文明等级（C），资源储备（R）以及人口数量（H）。在游戏开始时（第 0 天），三种属性的值均为 0。
随着游戏进程的进行，每一天玩家的三种属性都会对应增加，我们用一个二维数组 increase 来表示每天的增加情况。
这个二维数组的每个元素是一个长度为 3 的一维数组，例如 [[1,2,1],[3,4,2]] 表示第一天三种属性分别增加 1,2,1 而第二天分别增加 3,4,2。
所有剧情的触发条件也用一个二维数组 requirements 表示。
这个二维数组的每个元素是一个长度为 3 的一维数组，对于某个剧情的触发条件 c[i], r[i], h[i]，如果当前 C >= c[i] 且 R >= r[i] 且 H >= h[i] ，则剧情会被触发。
根据所给信息，请计算每个剧情的触发时间，并以一个数组返回。如果某个剧情不会被触发，则该剧情对应的触发时间为 -1 。
限制：
1 <= increase.length <= 10000
1 <= requirements.length <= 100000
0 <= increase[i] <= 10
0 <= requirements[i] <= 100000

贪心 + 二分。
时间复杂度 O(nlogn)
 */