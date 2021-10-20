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
https://leetcode-cn.com/problems/interval-list-intersections/

归并区间。
时间复杂度 O(m+n)
空间复杂度 O(m+n)
 */
