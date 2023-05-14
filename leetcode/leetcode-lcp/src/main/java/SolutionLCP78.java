public class SolutionLCP78 {
    public int rampartDefensiveLine(int[][] rampart) {
        int n = rampart.length;

        // [1, n-2] 个城墙中，能膨胀的最小值（即为二分答案的上界）
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            int l = rampart[i][0] - rampart[i - 1][1];
            int r = rampart[i + 1][0] - rampart[i][1];
            min = Math.min(min, l + r);
        }

        int left = 1;
        int right = min + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(rampart, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    // 时间复杂度 O(n) 校验能否膨胀 mid 个长度
    private boolean checkMid(int[][] rampart, int mid) {
        int n = rampart.length;
        // 上一个城墙膨胀的右端点
        int last = rampart[0][1];
        for (int i = 1; i < n - 1; i++) {
            int l = rampart[i][0] - last;
            // Math.max(0, mid - l) 为右侧膨胀距离，注意非负
            last = rampart[i][1] + Math.max(0, mid - l);
            if (last > rampart[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}
/*
LCP 78. 城墙防线
https://leetcode.cn/problems/Nsibyl/

LCCUP'23 春季战队赛 T2。

在探险营地间，小扣意外发现了一片城墙遗迹，在探索期间，却不巧遇到迁徙中的兽群向他迎面冲来。情急之下小扣吹响了他的苍蓝笛，随着笛声响起，遗迹中的城墙逐渐发生了横向膨胀。
已知 rampart[i] = [x,y] 表示第 i 段城墙的初始所在区间。当城墙发生膨胀时，将遵循以下规则：
- 所有的城墙会同时膨胀相等的长度；
- 每个城墙可以向左、向右或向两个方向膨胀。
小扣为了确保自身的安全，需要在所有城墙均无重叠的情况下，让城墙尽可能的膨胀。请返回城墙可以膨胀的 最大值 。
注意：
- 初始情况下，所有城墙均不重叠，且 rampart 中的元素升序排列；
- 两侧的城墙可以向外无限膨胀。
提示：
3 <= rampart.length <= 10^4
rampart[i].length == 2
0 <= rampart[i][0] < rampart[i][1] <= rampart[i+1][0] <= 10^8

二分答案。
时间复杂度 O(nlogn)
 */