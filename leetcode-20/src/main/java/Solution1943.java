import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1943 {
    public List<List<Long>> splitPainting(int[][] segments) {
        // 差分 计算每个位置对应的颜色和改变量并用哈希表存储
        Map<Integer, Long> colorMap = new HashMap<>();
        for (int[] segment : segments) {
            int left = segment[0];
            int right = segment[1];
            int color = segment[2];
            colorMap.put(left, colorMap.getOrDefault(left, 0L) + color);
            colorMap.put(right, colorMap.getOrDefault(right, 0L) - color);
        }

        // 将哈希表转化为数组并按数轴坐标升序排序
        List<long[]> axis = new ArrayList<>();
        for (Map.Entry<Integer, Long> entry : colorMap.entrySet()) {
            axis.add(new long[]{entry.getKey(), entry.getValue()});
        }
        axis.sort((o1, o2) -> (int) (o1[0] - o2[0]));

        // 对数组求前缀和计算对应颜色和
        int len = axis.size();
        for (int i = 1; i < len; ++i) {
            axis.get(i)[1] += axis.get(i - 1)[1];
        }

        // 遍历数组生成最终绘画结果
        List<List<Long>> res = new ArrayList<>();
        for (int i = 0; i < len - 1; ++i) {
            if (axis.get(i)[1] > 0) {
                res.add(List.of(axis.get(i)[0], axis.get(i + 1)[0], axis.get(i)[1]));
            }
        }
        return res;
    }
}
/*
1943. 描述绘画结果
https://leetcode-cn.com/problems/describe-the-painting/

第 57 场双周赛 T3。
注意 每种颜色 colori 互不相同。避免了诸如 5+7 和 7+5 合并的尴尬局面。
官方题解。差分 + 前缀和
时间复杂度 O(nlogn)
空间复杂度 O(n)
 */