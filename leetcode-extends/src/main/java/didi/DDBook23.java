package didi;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DDBook23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String[] lineN = new String[n];
        for (int i = 0; i < n; i++) {
            lineN[i] = scanner.nextLine();
        }

        List<String> res = solve(n, m, lineN);
        for (String re : res) {
            System.out.println(re);
        }
    }

    private static final int INF = Integer.MAX_VALUE / 2;

    private static List<String> solve(int n, int m, String[] lineN) {
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] lineIs = lineN[i].split(" ");
            for (int j = 0; j < m; j++) {
                if (lineIs[j].equals("a")) {
                    grid[i][j] = INF;
                } else {
                    grid[i][j] = Integer.parseInt(lineIs[j]);
                }
            }
        }

        // floyd
        for (int p = 0; p < n; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Math.min(grid[i][j], grid[i][p] + grid[p][j]);
                }
            }
        }

        List<String> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    continue;
                }
                if (grid[i][j] == INF) {
//                    resList.add(String.format("%s 到 %s 之间没路径", i, j));
                    resList.add(String.format("There is no path between %s and %s", i, j));
                } else {
//                    resList.add(String.format("%s 到 %s 之间的最短路径长度为:%s", i, j, grid[i][j]));
                    resList.add(String.format("The shortest distance between %s and %s is: %s", i, j, grid[i][j]));
                }
            }
        }
        return resList;
    }
}
/*
接驾最短距离算法
https://leetcode.cn/leetbook/read/didiglobal2/e7to0j/

接驾最短距离背景:滴滴打车方便了每个人，为了让出行更美好，调度引擎计算司机的接驾距离和预估距离是非常核心的算法，现在根据floyd 算法算出到达2点最近的距离，地点以元组矩阵的方式表示。
例如: {{0,a,10,a,30,100},{a,0,5,a,a,a},{a,a,0,50,a,a},{a,a,a,0,a,10},{a,a,a,20,0,60},{a,a,a,a,a,0}}，计算出最短距离。
格式：
输入：
- 输入 n*m 矩阵元组，矩阵中的每个元素代表一个点，元素的值标识确定好的距离
- 第一行一个整数 n，代表矩阵的行
- 第二行一个整数 m，代表矩阵的列
- 接下来 n 行，每行 m 个元素，以空格隔开
输出：
- 计算任何 2 点之间最短的距离
示例：
输入：
6
6
0 a a a 30 100
a 0 a a a a
1 a 0 50 a a
1 a a 0 a 10
a a a 20 a 60
a a 1 a a 0
输出：
0 到 1 之间没路径
0 到 2 之间的最短路径长度为:61
0 到 3 之间的最短路径长度为:50
0 到 4 之间的最短路径长度为:30
0 到 5 之间的最短路径长度为:60
1 到 0 之间没路径
1 到 2 之间没路径
1 到 3 之间没路径
1 到 4 之间没路径
1 到 5 之间没路径
2 到 0 之间的最短路径长度为:1
2 到 1 之间没路径
2 到 3 之间的最短路径长度为:50
2 到 4 之间的最短路径长度为:31
2 到 5 之间的最短路径长度为:60
3 到 0 之间的最短路径长度为:1
3 到 1 之间没路径
3 到 2 之间的最短路径长度为:11
3 到 4 之间的最短路径长度为:31
3 到 5 之间的最短路径长度为:10
4 到 0 之间的最短路径长度为:21
4 到 1 之间没路径
4 到 2 之间的最短路径长度为:31
4 到 3 之间的最短路径长度为:20
4 到 5 之间的最短路径长度为:30
5 到 0 之间的最短路径长度为:2
5 到 1 之间没路径
5 到 2 之间的最短路径长度为:1
5 到 3 之间的最短路径长度为:51
5 到 4 之间的最短路径长度为:32
 */