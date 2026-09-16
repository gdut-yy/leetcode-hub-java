public class Solution4045 {
    public int countGroups(int[] position, int[] speed, int distance) {
        int n = speed.length;
        int mn = speed[n - 1];
        int ans = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (speed[i] <= mn && position[i + 1] - position[i] > distance) {
                mn = speed[i];
                ans++;
            }
        }
        return ans;
    }
}
/*
4045. 统计机器人组数
https://leetcode.cn/problems/count-robot-groups/description/

第 518 场周赛 T3。

给你一个 严格递增 的整数数组 position，其中 position[i] 是第 i 个机器人（下标从 0 开始）在时间 t = 0 时的初始位置。
另给你一个整数数组 speed，其中 speed[i] 是第 i 个机器人的恒定速度（单位：单位/秒），以及一个整数 distance。
时间是连续的，以秒为单位。速度为 v 的机器人或机器人组在任意 t 秒的时间间隔内向右移动 v * t 个单位。
每当两个机器人或组之间的距离至多为 distance 时，它们就会合并成一个机器人组。
如果多个机器人或机器人组在同一时间满足合并条件，则所有合并 同时 发生。具体而言，任何相邻位置相差至多为 distance 的相连机器人或组都会合并为一个机器人组。
合并后，生成的机器人组将继承该组中 最右侧机器人 的当前位置和速度。一旦合并，机器人将永不分离。
返回在所有可能的合并发生后剩余的组数。
如果数组中的每个元素都严格大于其前一个元素（如果存在），则该数组是 严格递增 的。
提示：
1 <= position.length == speed.length <= 10^5
1 <= position[i], speed[i], distance <= 10^9
position 严格递增。

倒序遍历。
时间复杂度 O(n)。
相似题目: 853. 车队
https://leetcode.cn/problems/car-fleet/
1776. 车队 II
https://leetcode.cn/problems/car-fleet-ii/description/
 */