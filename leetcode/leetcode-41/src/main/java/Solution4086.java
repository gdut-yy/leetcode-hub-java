import java.util.Arrays;
import java.util.Comparator;

public class Solution4086 {
    public int minSelection(int[][] availableIntervals, int[][] targetIntervals) {
        Arrays.sort(availableIntervals, Comparator.comparingInt(p -> p[0])); // 按照左端点从小到大排序
        Arrays.sort(targetIntervals, Comparator.comparingInt(p -> p[0])); // 按照左端点从小到大排序

        int curEnd = 0; // 已建造的桥的右端点
        int i = 0;
        int ans = 0;
        for (int[] target : targetIntervals) {
            int tarL = target[0], tarR = target[1];
            while (curEnd < tarR) {
                // 当前最靠左的未覆盖位置
                int uncover = Math.max(tarL, curEnd);
                // 寻找下一座桥的最远点
                int nextEnd = curEnd;
                while (i < availableIntervals.length && availableIntervals[i][0] <= uncover) {
                    nextEnd = Math.max(nextEnd, availableIntervals[i][1]);
                    i++;
                }
                // 无法覆盖 uncover，或者无法继续向右延伸
                if (nextEnd < uncover || nextEnd == curEnd) {
                    return -1;
                }
                curEnd = nextEnd; // 建桥后，最远可以到达 nextEnd
                ans++;
            }
        }
        return ans;
    }
}
/*
4086. 覆盖目标区间的最少区间
https://leetcode.cn/problems/minimum-interval-selection-to-cover-target-intervals/description/

第 524 场周赛 T4。

给你两个二维整数数组 availableIntervals 和 targetIntervals，每个数组都表示一系列 闭区间。
从 availableIntervals 中选择一个 子集，使得 targetIntervals 中任何区间包含的 每一个实数点 都属于至少一个被选中的区间。
目标区间之外的点不需要被覆盖。选中的区间可以相互重叠，也可以延伸到目标区间之外。
返回你需要选择的 最小 区间数量。如果无法覆盖所有的目标区间，返回 -1。
数组的 子集 是指从该数组中选择的一些元素（可能不选择任何元素）组成的集合。
示例 1：
输入： availableIntervals = [[1,4],[1,7],[3,9],[5,10],[10,15]], targetIntervals = [[1,3],[2,5],[7,8],[10,13],[11,15],[12,13]]
输出： 3
示例 2：
输入： availableIntervals = [[4,6],[1,4],[2,5]], targetIntervals = [[3,4],[2,5],[6,7]]
输出： -1
示例 3：
输入： availableIntervals = [[1,2],[3,4]], targetIntervals = [[1,4]]
输出： -1
提示：
1 <= availableIntervals.length, targetIntervals.length <= 5 * 10^4
availableIntervals[i].length == targetIntervals[j].length == 2
1 <= availableIntervals[i][0] <= availableIntervals[i][1] <= 10^5
1 <= targetIntervals[j][0] <= targetIntervals[j][1] <= 10^5

区间覆盖问题
https://leetcode.cn/problems/minimum-interval-selection-to-cover-target-intervals/solutions/4045141/qu-jian-he-bing-qu-jian-fu-gai-pythonjav-05u0/
 */