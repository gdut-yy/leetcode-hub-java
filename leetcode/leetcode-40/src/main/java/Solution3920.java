import java.util.ArrayList;
import java.util.List;

public class Solution3920 {
    public int maxFixedPoints(int[] nums) {
        int n = nums.length;
        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= i) {
                points.add(new int[]{nums[i], i - nums[i]});
            }
        }
        points.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });

        ArrayList<Integer> tails = new ArrayList<>();
        for (int[] p : points) {
            int d = p[1];
            int left = 0, right = tails.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails.get(mid) <= d) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == tails.size()) {
                tails.add(d);
            } else {
                tails.set(left, d);
            }
        }
        return tails.size();
    }
}
/*
3920. 删除元素后最大固定点数目
https://leetcode.cn/problems/maximize-fixed-points-after-deletions/description/

第 500 场周赛 T4。

给你一个整数数组 nums。
如果 nums[i] == i，则位置 i 被称为 固定点。
允许你从数组中删除 任意 数量的元素（包括零个）。在每次删除后，剩余元素 向左移动，并且下标从 0 开始重新分配。
返回一个整数，表示在执行任意次数的删除操作后，可以获得的 最大 固定点数量。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5

最长递增子序列。
https://chat.deepseek.com/a/chat/s/1a8306d9-ca68-49c8-b901-3536b0b1395f
时间复杂度 O(nlogn)。
 */