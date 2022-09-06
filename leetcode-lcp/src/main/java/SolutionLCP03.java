import java.util.HashSet;
import java.util.Set;

public class SolutionLCP03 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        // 路径中的点
        Set<String> pathSet = new HashSet<>();
        int cntX = 0;
        int cntY = 0;
        pathSet.add(cntX + ":" + cntY);
        for (char ch : command.toCharArray()) {
            if (ch == 'U') {
                cntY++;
            } else {
                cntX++;
            }
            pathSet.add(cntX + ":" + cntY);
        }

        // 需要走几个循环
        int circle = Math.min(x / cntX, y / cntY);
        // 终点不在机器人运动的轨迹中
        if (!pathSet.contains((x - circle * cntX) + ":" + (y - circle * cntY))) {
            return false;
        }

        for (int[] obstacle : obstacles) {
            if (obstacle[0] > x || obstacle[1] > y) {
                continue;
            }
            circle = Math.min(obstacle[0] / cntX, obstacle[1] / cntY);
            // 障碍物在机器人运动的轨迹中
            if (pathSet.contains((obstacle[0] - circle * cntX) + ":" + (obstacle[1] - circle * cntY))) {
                return false;
            }
        }
        return true;
    }
}
/*
LCP 03. 机器人大冒险
https://leetcode.cn/problems/programmable-robot/

力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令有两种：
1.U: 向y轴正方向移动一格
2.R: 向x轴正方向移动一格。
不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
限制：
2 <= command的长度 <= 1000
command由U，R构成，且至少有一个U，至少有一个R
0 <= x <= 1e9, 0 <= y <= 1e9
0 <= obstacles的长度 <= 1000
obstacles[i]不为原点或者终点

哈希模拟。
 */