import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3728 {
    public long countStableSubarrays(int[] capacity) {
        int n = capacity.length;
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + capacity[i];
        }

        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndices.computeIfAbsent(capacity[i], e -> new ArrayList<>()).add(i);
        }

        long totalCount = 0;
        for (List<Integer> indices : valueToIndices.values()) {
            int size = indices.size();
            if (size < 2) continue;

            Map<Long, Integer> freq = new HashMap<>();
            for (int idx : indices) {
                long sumVal = ps[idx + 1];
                freq.merge(sumVal, 1, Integer::sum);
            }

            int j = 0;
            for (int i = 0; i < size; i++) {
                int leftIdx = indices.get(i);
                while (j < size && indices.get(j) < leftIdx + 2) {
                    int removeIdx = indices.get(j);
                    long sumVal = ps[removeIdx + 1];
                    if (freq.merge(sumVal, -1, Integer::sum) == 0) {
                        freq.remove(sumVal);
                    }
                    j++;
                }
                long target = ps[leftIdx] + 3L * capacity[leftIdx];
                totalCount += freq.getOrDefault(target, 0);
            }
        }
        return totalCount;
    }
}
/*
3728. 边界与内部和相等的稳定子数组
https://leetcode.cn/problems/stable-subarrays-with-equal-boundary-and-interior-sum/description/

第 473 场周赛 T3。

给你一个整数数组 capacity。
当满足以下条件时，子数组 capacity[l..r] 被视为 稳定 数组：
- 其长度 至少 为 3。
- 首 元素与 尾 元素都等于它们之间所有元素的 和（即 capacity[l] = capacity[r] = capacity[l + 1] + capacity[l + 2] + ... + capacity[r - 1]）。
返回一个整数，表示 稳定子数组 的数量。
子数组 是数组中的连续且非空的元素序列。
提示：
3 <= capacity.length <= 10^5
-10^9 <= capacity[i] <= 10^9

前缀和 + 分组计数。
https://yuanbao.tencent.com/chat/naQivTmsDa/ab052315-488f-4cb8-bd52-ce9bb4d57ab4
时间复杂度 O(n)。
 */