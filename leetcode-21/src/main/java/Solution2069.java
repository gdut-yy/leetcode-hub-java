import java.util.Arrays;

public class Solution2069 {
    static class Robot {
        private final int width;
        private final int height;
        // 周长 Robot(6, 3) 周长 14
        private final int round;
        // 总步数
        private int total;
        // 记录状态
        private int curX;
        private int curY;
        private String curDir;

        public Robot(int width, int height) {
            this.width = width;
            this.height = height;
            this.round = width + height + width + height - 4;
            this.curDir = "East";
        }

        public void move(int num) {
            this.total += num;
            // 第 n 圈 round + cnt
            int cnt = total % round;
            if (cnt <= width - 1) {
                curX = cnt;
                curY = 0;
                curDir = "East";
                // (0, 0) 只有第一圈朝向 "East" 其余都朝向 "South"
                if (cnt == 0 && total > 0) {
                    curDir = "South";
                }
            } else if (cnt <= (width - 1) + (height - 1)) {
                curX = width - 1;
                curY = cnt - (width - 1);
                curDir = "North";
            } else if (cnt <= (width - 1) + (height - 1) + (width - 1)) {
                curX = (width - 1) - (cnt - (width - 1) - (height - 1));
                curY = height - 1;
                curDir = "West";
            } else {
                curX = 0;
                curY = (height - 1) - (cnt - (width - 1) - (height - 1) - (width - 1));
                curDir = "South";
            }
        }

        public int[] getPos() {
            return new int[]{curX, curY};
        }

        public String getDir() {
            return curDir;
        }
    }

    public static void main(String[] args) {
        Robot robot = new Robot(6, 3);
        robot.move(2);  // 机器人朝东移动 2 步，到达 (2, 0) ，并朝东。
        robot.move(2);  // 机器人朝东移动 2 步，到达 (4, 0) ，并朝东。
        System.out.println(Arrays.toString(robot.getPos())); // 返回 [4, 0]
        System.out.println(robot.getDir()); // 返回 "East"
        robot.move(2);  // 朝东移动 1 步到达 (5, 0) ，并朝东。
        // 下一步继续往东移动将出界，所以逆时针转变方向朝北。
        // 然后，往北移动 1 步到达 (5, 1) ，并朝北。
        robot.move(1);  // 朝北移动 1 步到达 (5, 2) ，并朝 北 （不是朝西）。
        robot.move(4);  // 下一步继续往北移动将出界，所以逆时针转变方向朝西。
        // 然后，移动 4 步到 (1, 2) ，并朝西。
        System.out.println(Arrays.toString(robot.getPos())); // 返回 [1, 2]
        System.out.println(robot.getDir()); // 返回 "West"
    }
}
/*
2069. 模拟行走机器人 II
https://leetcode-cn.com/problems/walking-robot-simulation-ii/

第 65 场双周赛 T2。

请你实现 Robot 类：
Robot(int width, int height) 初始化一个 width x height 的网格图，机器人初始在 (0, 0) ，方向朝 "East" 。
void move(int num) 给机器人下达前进 num 步的指令。
int[] getPos() 返回机器人当前所处的格子位置，用一个长度为 2 的数组 [x, y] 表示。
String getDir() 返回当前机器人的朝向，为 "North" ，"East" ，"South" 或者 "West" 。

模拟。需注意边界条件。
 */
