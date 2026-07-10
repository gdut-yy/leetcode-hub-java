public class Solution3968 {
    public int maxDistance(String moves) {
        int x = 0, y = 0, chose = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') y++;
            else if (c == 'D') y--;
            else if (c == 'L') x--;
            else if (c == 'R') x++;
            else chose++;
        }
        return Math.abs(x) + Math.abs(y) + chose;
    }
}
/*
3968. 移动后的最大曼哈顿距离
https://leetcode.cn/problems/maximum-manhattan-distance-after-all-moves/description/

第 507 场周赛 T1。

给你一个由字符 'U'、'D'、'L'、'R' 和 '_' 组成的字符串 moves。
从原点 (0, 0) 出发，每个字符表示二维平面上的一次移动：
- 'U'：向上移动 1 个单位。
- 'D'：向下移动 1 个单位。
- 'L'：向左移动 1 个单位。
- 'R'：向右移动 1 个单位。
- '_'：可以独立地替换为 'U'、'D'、'L' 或 'R' 中的任意一个字符。
返回执行完所有移动后，能够达到的距离原点的 最大曼哈顿距离 。
两点 (x1, y1) 和 (x2, y2) 之间的 曼哈顿距离 为 |x1 - x2| + |y1 - y2|。
提示：
1 <= moves.length <= 10^5
moves 仅由 'U'、'D'、'L'、'R' 和 '_' 组成。

贪心。
时间复杂度 O(n)。
 */