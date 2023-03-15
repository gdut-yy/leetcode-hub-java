package ponyai;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Ponyai001 {
    private static final int[][] DIRECTIONS8 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        // input
        String[] line0 = reader.readLine().split(" ");
        int n = Integer.parseInt(line0[0]);
        int q = Integer.parseInt(line0[1]);
        int[][] lines = new int[q][4];
        for (int i = 0; i < q; i++) {
            String[] lineStr = reader.readLine().split(" ");
            lines[i][0] = Integer.parseInt(lineStr[0]);
            lines[i][1] = Integer.parseInt(lineStr[1]);
            lines[i][2] = Integer.parseInt(lineStr[2]);
            lines[i][3] = Integer.parseInt(lineStr[3]);
        }

        // solution
        int[] res = solution(n, lines);

        // output
        for (int re : res) {
            writer.write(String.valueOf(re));
            writer.write(System.lineSeparator());
        }
        writer.close();
        reader.close();
    }

    private static int[] solution(int n, int[][] lines) {
        // 模拟
        int radius = 100;
        int len = radius * 2 + 1;
        int[][] vehicles = new int[len][len];
        vehicles[radius][radius] = n;
        rec(vehicles, radius, radius, 0);
        int[][] sums = new int[len + 1][len + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + vehicles[i - 1][j - 1];
            }
        }

        int[] res = new int[lines.length];
        for (int idx = 0; idx < lines.length; idx++) {
            int x1 = lines[idx][0];
            int y1 = lines[idx][1];
            int x2 = lines[idx][2];
            int y2 = lines[idx][3];
            if (x1 > x2 || y1 > y2) {
                res[idx] = 0;
                continue;
            }
            x1 = Math.max(Math.min(x1 + radius, len - 1), 0);
            y1 = Math.max(Math.min(y1 + radius, len - 1), 0);
            x2 = Math.max(Math.min(x2 + radius, len - 1), 0);
            y2 = Math.max(Math.min(y2 + radius, len - 1), 0);
            res[idx] = sums[x2 + 1][y2 + 1] - sums[x1][y2 + 1] - sums[x2 + 1][y1] + sums[x1][y1];
        }
        return res;
    }

    private static void rec(int[][] vehicles, int x, int y, int add) {
        vehicles[x][y] += add;
        if (vehicles[x][y] < 8) {
            return;
        }
        int a = vehicles[x][y] / 8;
        vehicles[x][y] %= 8;
        for (int i = 0; i < 8; i++) {
            rec(vehicles, x + DIRECTIONS8[i][0], y + DIRECTIONS8[i][1], a);
        }
    }
}
/*
Pony.ai-001. 车队管理
https://leetcode.cn/problems/nDTGrx/

小马智行(Pony.ai) 在广州南沙区有一支稳定运营的自动驾驶车队，可以将南沙区的地图看做一个二维的网格图，小马智行的广州 office 在 (0, 0) 位置。
公司现在有 n 台车，每天会按如下规则从围绕南沙区进行路测：
1.初始 n 辆车都在公司。
2.放眼整个南沙地图，每过一分钟，若有一个网格的车数大于等于 8，则这个网格同时会有 8 辆车分别前往上，下，左，右，
左上，左下，右上，右下的网格，不停执行该步骤直到所有的车辆的位置都固定不变。
作为小马智行车辆控制中心的一员，你需要监管车辆运营的情况，你需要等到所有车辆的位置固定之后，进行 q 次抽样统计，
每次需要统计出以 (x1,y1) 为左下角，以 (x2,y2) 为右上角的矩形范围内车辆的车辆的数目。
输入描述：
第一行为 n 和 q，分别代表初始 office 内的车辆数和抽样的次数。
之后 q 行，每行包含 4 个变量，x1,y1,x2,y2 含义见题目描述。
1 <= n <= 10^5, 1 <= q <= 10^5, x,y∈[-10^9,10^9] 后，进行 q 次抽样，每次查询以 (x1,y1) 为左下角，
以 (x2,y2) 为右上角的矩形范围内车辆的数目。
输出描述：
输出 q 次抽样的结果，每次结果独占一行。
输入
8 2
0 0 0 0
-1 -1 1 1
输出
0
8
说明
第 0 分钟所有车辆都在 office 处。
第 1 分钟及以后, 8 辆车分别在 (-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1) 这 8 个位置。
 */