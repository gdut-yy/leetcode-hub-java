import java.util.Arrays;
import java.util.Comparator;

public class Solution973 {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * o[1])));
        return Arrays.copyOf(points, k);
    }
}
/*
973. 最接近原点的 K 个点
https://leetcode-cn.com/problems/k-closest-points-to-origin/

第 119 场周赛 T1。
按平方和升序排列后，返回子数组即可。
 */
