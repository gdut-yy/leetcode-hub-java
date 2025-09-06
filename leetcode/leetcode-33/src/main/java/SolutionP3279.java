import java.util.HashMap;
import java.util.Map;

public class SolutionP3279 {
    public long maxArea(int height, int[] positions, String directions) {
        int cycle = 2 * height;
        long area = 0, diff = 0;
        Map<Integer, Integer> changes = new HashMap<>();
        int n = positions.length;
        for (int i = 0; i < n; i++) {
            int startDirection = directions.charAt(i) == 'U' ? 1 : -1;
            area += positions[i];
            diff += startDirection;
            updateChanges(positions[i], startDirection, height, changes);
        }
        long maximumArea = area;
        for (int i = 1; i < cycle; i++) {
            area += diff;
            maximumArea = Math.max(maximumArea, area);
            diff += changes.getOrDefault(i, 0);
        }
        return maximumArea;
    }

    private void updateChanges(int startPosition, int startDirection, int height, Map<Integer, Integer> changes) {
        int time1 = startDirection > 0 ? height - startPosition : startPosition;
        int time2 = time1 + height;
        changes.merge(time1, -2 * startDirection, Integer::sum);
        changes.merge(time2, 2 * startDirection, Integer::sum);
    }
}
/*
$3279. 活塞占据的最大总区域
https://leetcode.cn/problems/maximum-total-area-occupied-by-pistons/description/

一台旧车的引擎中有一些活塞，我们想要计算活塞 下方 的 最大 区域。
给定：
- 一个整数 height，表示活塞 最大 可到达的高度。
- 一个整数数组 positions，其中 positions[i] 是活塞 i 的当前位置，等于其 下方 的当前区域。
- 一个字符串 directions，其中 directions[i] 是活塞 i 的当前移动方向，'U' 表示向上，'D' 表示向下。
每一秒：
- 每个活塞向它的当前方向移动 1 单位。即如果方向向上，positions[i] 增加 1。
- 如果一个活塞到达了其中一个终点，即 positions[i] == 0 或 positions[i] == height，它的方向将会改变。
返回所有活塞下方的最大可能区域。
提示：
1 <= height <= 10^6
1 <= positions.length == directions.length <= 10^5
0 <= positions[i] <= height
directions[i] 为 'U' 或 'D'。

哈希表枚举。
朴素的思路是模拟每一秒的活塞变化并计算一个周期内的每一秒的所有活塞下方的面积。用 n 表示活塞的数量，则每一秒都需要遍历 n 个活塞，因此每一秒计算移动后的所有活塞下方的面积的时间是 O(n)，时间复杂度是 O(n * height)，该时间复杂度过高，需要优化。
https://leetcode.cn/problems/maximum-total-area-occupied-by-pistons/solutions/2971660/3279-huo-sai-zhan-ju-de-zui-da-zong-mian-gb7h/
时间复杂度 O(n+height)。
 */