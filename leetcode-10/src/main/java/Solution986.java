import java.util.ArrayList;
import java.util.List;

public class Solution986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int idx1 = 0;
        int idx2 = 0;
        List<int[]> resList = new ArrayList<>();
        while (idx1 < firstList.length && idx2 < secondList.length) {
            int begin = Math.max(firstList[idx1][0], secondList[idx2][0]);
            int end = Math.min(firstList[idx1][1], secondList[idx2][1]);
            if (begin <= end) {
                resList.add(new int[]{begin, end});
            }
            if (firstList[idx1][1] < secondList[idx2][1]) {
                idx1++;
            } else {
                idx2++;
            }
        }
        // List<int[]> => int[][]
        int resLen = resList.size();
        int[][] res = new int[resLen][2];
        for (int i = 0; i < resLen; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
/*
986. 区间列表的交集
https://leetcode.cn/problems/interval-list-intersections/

第 122 场周赛 T3。

给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。
每个区间列表都是成对 不相交 的，并且 已经排序 。
返回这 两个区间列表的交集 。
形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
提示：
0 <= firstList.length, secondList.length <= 1000
firstList.length + secondList.length >= 1
0 <= starti < endi <= 10^9
endi < starti+1
0 <= startj < endj <= 10^9
endj < startj+1

归并区间。
时间复杂度 O(m+n)
空间复杂度 O(m+n)
 */
