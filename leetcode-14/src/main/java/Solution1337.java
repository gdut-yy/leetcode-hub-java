import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int sum = Arrays.stream(mat[i]).sum();
            lists.add(List.of(sum, i));
        }
        lists.sort((o1, o2) -> {
            if (o1.get(0).equals(o2.get(0))) {
                return Integer.compare(o1.get(1), o2.get(1));
            }
            return Integer.compare(o1.get(0), o2.get(0));
        });

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = lists.get(i).get(1);
        }
        return res;
    }
}
/*
1337. 矩阵中战斗力最弱的 K 行
https://leetcode.cn/problems/the-k-weakest-rows-in-a-matrix/

给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
提示：
m == mat.length
n == mat[i].length
2 <= n, m <= 100
1 <= k <= m
matrix[i][j] 不是 0 就是 1

模拟。
 */
