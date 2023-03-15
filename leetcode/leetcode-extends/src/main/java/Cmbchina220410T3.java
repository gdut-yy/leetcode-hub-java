import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Cmbchina220410T3 {
    public int[] lightSticks(int height, int width, int[] indices) {
        int edgeNum = (height + 1) * width + height * (width + 1);
        int mod = width * 2 + 1;

        int[][] grid = new int[height + 1][width + 1];
        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= width; j++) {
                grid[i][j] = i * (width + 1) + j;
            }
        }

        Map<Integer, int[]> edges = new HashMap<>();
        int idx = 0;

        for (int i = 0; i < width; i++) {
            edges.put(idx, new int[]{i, i + 1});
            idx++;
        }
        for (int i = 0; i <=width; i++) {
            edges.put(idx, new int[]{});
        }
//        for (int i = 0; i <; i++) {
//
//        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Cmbchina220410T3().lightSticks(1, 2, new int[]{3})));
    }
}
/*
招商银行-03. 点燃木棒
https://leetcode.cn/contest/cmbchina-2022spring/problems/Dk2Ytp/

有一个的木棒摆成的长方形网格，各个木棒，各个端点按照如下左图所示的方式编号。
在其中取走部分木棒，取走的木棒的编号记录于整数数组 indices。取完之后木棒网格一种可能的形式例如上右图所示。在 0 时刻，在网格中点燃某个端点。
- 一根木棒的一端被点燃，或者其他木棒燃烧到了相邻接的端点，则自此端点开始向另一端均匀地燃烧。
- 每根木棒从一端均匀地燃烧到另一端花费时间 1。
给定网格的高 height、宽 width 以及 indices。请问在 0 时刻点燃哪一个端点，可以使得在最短的时间内全体木棒都燃尽。返回一个升序排序的数组记录所有满足要求的端点编号。如果不存在这样的端点，返回空数组。
注意：
输入用例保证，indices 中的木棒编号都是合法的。
示例 1：
输入：
height = 1, width = 2, indices = [3]
输出：[0,1,2,3,4,5]
解释：如图所示，点燃所有端点，燃尽时间均为 3。
示例 2：
输入：
height = 2, width = 2, indices = [2,5,6,7,8,10,11]
输出：[2]
解释：如下图所示。点燃端点 [2] 燃尽时间为 2，是最小燃尽时间。
示例 3：
输入：
height = 1, width = 1, indices = [0,3]
输出：[]
解释：点燃任何一个端点，都无法燃尽所有木棒。因此返回空数组。
提示：
1 <= height, width <= 50
0 <= indices.length <= (height+1)*width+height*(width+1)
indices 中的值两两不同
0 <= indices[i] < (height+1)*width+height*(width+1)
 */