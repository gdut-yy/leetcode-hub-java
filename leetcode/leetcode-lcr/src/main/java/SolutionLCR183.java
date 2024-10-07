import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SolutionLCR183 {
    public int[] maxAltitude(int[] heights, int limit) {
        int n = heights.length;
        if (n == 0) return new int[0];

        Deque<Integer> maxDq = new ArrayDeque<>(); // maxDq.getFirst() 为区间内最大值
        for (int i = 0; i < limit; i++) {
            while (!maxDq.isEmpty() && heights[i] >= heights[maxDq.getLast()]) maxDq.removeLast();
            maxDq.addLast(i);
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(heights[maxDq.getFirst()]);
        for (int i = limit; i < n; i++) {
            while (!maxDq.isEmpty() && heights[i] >= heights[maxDq.getLast()]) maxDq.removeLast();
            maxDq.addLast(i);
            while (maxDq.getFirst() <= i - limit) {
                maxDq.removeFirst();
            }
            ans.add(heights[maxDq.getFirst()]);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
/*
LCR 183. 望远镜中最高的海拔
https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/

科技馆内有一台虚拟观景望远镜，它可以用来观测特定纬度地区的地形情况。该纬度的海拔数据记于数组 heights ，其中 heights[i] 表示对应位置的海拔高度。请找出并返回望远镜视野范围 limit 内，可以观测到的最高海拔值。
提示：
你可以假设输入总是有效的，在输入数组不为空的情况下：
1 <= limit <= heights.length
-10000 <= heights[i] <= 10000

同: 239. 滑动窗口最大值
https://leetcode.cn/problems/sliding-window-maximum/
 */