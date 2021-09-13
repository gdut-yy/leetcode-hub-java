import java.util.HashMap;
import java.util.Map;

public class Solution2001 {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Integer> cntMap = new HashMap<>();
        for (int[] rectangle : rectangles) {
            int width = rectangle[0];
            int height = rectangle[1];
            double key = height / (double) width;
            cntMap.put(key, cntMap.getOrDefault(key, 0) + 1);
        }
        long res = 0;
        for (Map.Entry<Double, Integer> entry : cntMap.entrySet()) {
            int value = entry.getValue();
            if (value > 1) {
                res += ((long) value * value - value) / 2;
            }
        }
        return res;
    }
}
/*
2001. 可互换矩形的组数
https://leetcode-cn.com/problems/number-of-pairs-of-interchangeable-rectangles/

第 258 场周赛 T2。
神奇。Double 也可以作为 HashMap 的 key
 */