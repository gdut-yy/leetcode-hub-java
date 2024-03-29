package ponyai;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ponyai004 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        String[] line0 = reader.readLine().split(" ");
        int n = Integer.parseInt(line0[0]);
        int h = Integer.parseInt(line0[1]);
        String[] line1 = reader.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(line1[i]);
        }
        int[] res = solution(n, h, nums);
        for (int re : res) {
            writer.write(String.valueOf(re));
            writer.write(System.lineSeparator());
        }
        writer.close();
        reader.close();
    }

    private static int[] solution(int n, int h, int[] nums) {
        Deque<Node> stack = new ArrayDeque<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int now = nums[i];
            double slope = 0.0;
            if (now != 0) {
                slope = (now - h) * 1.0 / (i + 1);
            }
            // 精度
            double eps = 1e-10;
            while (!stack.isEmpty() && (slope - stack.peek().slope) >= eps) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek().id;
            }
            stack.push(new Node(i + 1, slope));
        }
        return res;
    }

    private static class Node {
        int id;
        double slope;

        public Node(int id, double slope) {
            this.id = id;
            this.slope = slope;
        }
    }
}
/*
Pony.ai-004. 谁挡住了我的红绿灯
https://leetcode.cn/problems/vgKew1/

命运的十字路口前，有 nn 辆车在等红灯。还来不及思考此刻的选择会将他们带向何方，司机们发现了一个更现实的问题——由于车的高度不尽相同，
某些车会因前车的遮挡而无法看到红绿灯。这时候，“谁挡住了谁的红绿灯”便成为一个……很好的笔试题！
现已知红绿灯高度为 h, n 辆按距离红绿灯由近到远分别标号为 1...n，第 i 辆车与红绿灯的距离为 i，高度为 ai。为简化问题，
我们以距红绿灯的距离为 x 轴，高度为 y 轴建立平面直角坐标系，则红绿灯可抽象为一点 (0,h)，第 i 辆车可抽象为线段 (i,0)−(i,ai)。
我们称车 j 挡住了车 i 的红绿灯，当且仅当 j<1，且车 i 看红绿灯的视线，即 (i,ai) 与 (0,h) 的连线与代表车 j 的线段
 (j, 0) - (j, a_j) 相交（含两端）。
现在，我们需要你对每辆车计算谁挡住了它的红绿灯；即对于每一辆车 i ，求最大的 j 满足“车 j 挡住了车 i 的红绿灯”。
输入描述：
第一行包含两个非负整数 n 和 h ；
第二行包含 n 个非负整数 。
输出描述：
输出共有 n 行，第 i 行包含对于车 i 的答案，若没有车挡住车 i ，则该行输出 0。
备注
20% 的数据 n ≤ 10^4
50% 的数据 n ≤ 10^5
80% 的数据 n ≤ 5×10^5
100% 的数据 n ≤ 2×10^6，0 ≤ h,ai ≤ 10^9
示例 1
输入
9 5
5 4 3 4 3 3 3 3 3
输出
0
1
2
1
4
4
4
4
1
 */