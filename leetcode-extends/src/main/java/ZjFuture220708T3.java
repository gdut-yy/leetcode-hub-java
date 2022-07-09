import java.util.ArrayList;
import java.util.List;

public class ZjFuture220708T3 {
    public int buildTransferStation(int[][] area) {
        int M = area.length;
        int N = area[0].length;

        // 预处理
        List<Integer> rowsList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (area[i][j] == 1) {
                    rowsList.add(i);
                }
            }
        }
        List<Integer> colsList = new ArrayList<>();
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < M; i++) {
                if (area[i][j] == 1) {
                    colsList.add(j);
                }
            }
        }

        // 中位数
        int medianRow = rowsList.get(rowsList.size() / 2);
        int medianCol = colsList.get(colsList.size() / 2);

        // 求和
        int sum = 0;
        for (int row : rowsList) {
            sum += Math.abs(row - medianRow);
        }
        for (int col : colsList) {
            sum += Math.abs(col - medianCol);
        }
        return sum;
    }
}
/*
zj-future03. 快递中转站选址
https://leetcode.cn/contest/zj-future2022/problems/kflZMc/

某区域地图记录在 k 二维数组 area，其中 0 表示空地，1 表示快递分发点。
若希望选取一个地点设立中转站，使得中转站至各快递分发点的「曼哈顿距离」总和最小。请返回这个 最小 的距离总和。
注意：
曼哈顿距离：distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|
所有位置均可作为快递中转站的设立点。
示例 1：
输入: area = [[0,1,0,0,0],[0,0,0,0,1],[0,0,1,0,0]]
输出: 5
解释: 三个快递分发点分别位于(0,1)，(1,4) 和 (2,2):
     (1,2) 是最佳的中转站选址，总距离为 2 + 2 + 1 = 5。
示例 2:
输入: area = [[1,1],[1,1]]
输出: 4
解释: (0,0) 是最佳的中转站选址之一，总距离为 0 + 1 + 1 + 2 = 4。
提示:
m == area.length
n == area[i].length
1 <= m, n <= 200
area[i][j] == 0 或 1.
area 中 至少 有两个快递分发点

同: $296. 最佳的碰头地点
https://leetcode.cn/problems/best-meeting-point/
 */