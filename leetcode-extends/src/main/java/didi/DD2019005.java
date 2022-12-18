package didi;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DD2019005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] lines = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                lines[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve(n, m, lines));
    }

    private static final int INF = Integer.MAX_VALUE / 2;

    private static String solve(int n, int m, int[][] lines) {
        // f 和 t 分别表示出发城市和到达城市的编号，取值范围 0 到 n-1，其中 0 表示 A 市，1 表示 B 市
        // a 表示航空公司编号，取值范围 0 到 m-1
        // p 表示价格，取值范围大于 0
        // f -> [t, a, p]
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] tuple : lines) {
            adj.computeIfAbsent(tuple[0], key -> new ArrayList<>()).add(new int[]{tuple[1], tuple[2], tuple[3]});
        }

        boolean[] visited = new boolean[n + 1];
        // noDiscount[i] 表示到达 i 站且前一站不打折的最小价格, discount[i] 表示到达 i 站且前一站打折的最小价格
        int[] noDiscount = new int[n + 1];
        int[] discount = new int[n + 1];
        Arrays.fill(noDiscount, INF);
        Arrays.fill(discount, INF);
        // 优先队列优化
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        // [t, a, p]
        minHeap.add(new int[]{0, -1, 0});
        noDiscount[0] = 0;
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.remove();
            int ut = top[0];
            int ua = top[1];
            int up = top[2];
            if (visited[ut]) {
                continue;
            }
            visited[ut] = true;

            for (int[] tuple : adj.getOrDefault(ut, new ArrayList<>())) {
                int vt = tuple[0];
                int va = tuple[1];
                int vp = tuple[2];

                // 如连续乘坐两班同一航空公司的航班，可以给与两张机票总价 7 折优惠。
                if (ua == va) {
                    int price = (noDiscount[ut] - up) + (int) Math.floor(0.7 * (up + vp));
                    if (discount[vt] > price) {
                        discount[vt] = price;
                    }
                }
                int price = Math.min(noDiscount[ut], discount[ut]) + vp;
                if (noDiscount[vt] > price) {
                    noDiscount[vt] = price;
                    minHeap.add(new int[]{vt, va, vp});
                }
            }
        }
        return String.valueOf(Math.min(noDiscount[1], discount[1]));
    }
}
/*
DD-2019005. 最便宜的机票
https://leetcode.cn/problems/T33Pzl/

小明准备购买从 A 城市前往 B 城市的机票，可以选择直飞路线，也可以选择任意多段中转路线。
不同的航班由不同航空公司承运，所有航空公司均有一项优惠政策:如连续乘坐两班同一航空公司的航班，可以给与两张机票总价 7 折优惠。
现给出所有航班起始地、目的地、机票价格及承运航空公司信息，找出从 A 市到 B 市最便宜的机票购买方案，并输出最便宜的机票购买方案的总价格。
补充说明：
至少存在一条路线(直飞或中转)可以从 A 市到达 B 市，因此不需考虑不可到达的情形
折扣票必须两段直接连续，例如乘坐 X 航空公司航班从 A 到 C 再从 C 到 D，则享受折扣，
但如果乘坐 X 航空公司航班从 A 到 C 后，转乘 Y 航空公司 航班从 C 到 D，再乘坐 X 航空公司航班从 D 到 E，则不享受折扣
折扣航段不能重叠，但可以选择，例如购买 X 航空公司从 A 到 B，B 到 C，C 到 D三段连续机票，可以选择“A 到 B、B 到 C 打折”，也可以选 择“B 到 C、C 到 D 打折”，但二者只能选其一
打折机票折扣后价格取整，例如，一张 115 元机票和一张 200 元机票，打 7 折后价格为 220
购买的所有机票必须使用，如购入两张连续航程打折机票，不允许只乘坐第一段航程，而不乘坐第二段航程
考点：
对数据结构中图概念的掌握，能构造邻接矩阵或邻接表表示图结构
对于求解单源加权最短路径的掌握，能通过 Djisktra 算法或 Bellman–Ford 算法求解单源最短路径问题，并能灵活运用，解决略有变化的实际问题
基本的编程能力
格式：
输入：
- 第一行一个整数 n，表示共 n 个城市
- 第二行一个整数 m，表示共 m 个航空公司
- 第三行和第四行分别表示后面表示航班的二维数组的行数和列数，其中行数表示共有多少航班，列数固定为 4
- 从第五行开始，每行四个整数“f t a p”，用空格分隔，f 和 t 分别表示出发城市和到达城市的编号，取值范围 0 到 n-1，其中 0 表示 A 市，1 表示 B 市;
a 表示航空公司编号，取值范围 0 到 m-1;p 表示价格，取值范围大于 0
输出：
- 一个整数，表示最便宜的机票购买方案的总价格
示例：
输入：
7
2
8
4
0 1 0 100
0 2 0 50
2 1 0 2220
0 3 0 5
3 4 1 5
4 5 1 5
5 6 1 5
6 1 0 5
输出：22

Dijkstra + 动态规划
 */
