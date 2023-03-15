public class SolutionLCP29 {
    // https://leetcode.cn/problems/SNJvJP/solution/java-yi-ceng-ceng-mo-ni-hui-chao-shi-dan-q8vh/
    public int orchestraLayout(int num, int xPos, int yPos) {
        int start = 1;
        long deep = Math.min(Math.min(xPos, yPos), Math.min(num - xPos - 1, num - yPos - 1));
        long count = ((long) num * deep - deep * deep) * 4;
        start = (int) ((count + start - 1) % 9 + 1);
        num -= deep * 2;
        count = ((long) num - 1) * 4;
        long dist = (long) xPos + (long) yPos - 2 * deep;
        if (xPos == num + deep - 1 || (yPos == deep && xPos != deep)) {
            dist = count - dist;
        }
        return (int) ((dist + start - 1) % 9 + 1);
    }
}
/*
LCP 29. 乐团站位
https://leetcode.cn/problems/SNJvJP/

某乐团的演出场地可视作 num * num 的二维矩阵 grid（左上角坐标为 [0,0])，每个位置站有一位成员。乐团共有 9 种乐器，乐器编号为 1~9，每位成员持有 1 个乐器。
为保证声乐混合效果，成员站位规则为：自 grid 左上角开始顺时针螺旋形向内循环以 1，2，...，9 循环重复排列。例如当 num = 5 时，站位如图所示
请返回位于场地坐标 [Xpos,Ypos] 的成员所持乐器编号。
提示：
1 <= num <= 10^9
0 <= Xpos, Ypos < num
 */