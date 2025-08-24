import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution3645 {
    public long maxTotal(int[] value, int[] limit) {
        int n = value.length;
        List<Integer>[] groups = new ArrayList[n + 1];
        Arrays.setAll(groups, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            groups[limit[i]].add(value[i]);
        }

        long ans = 0;
        for (int k = 1; k <= n; k++) {
            List<Integer> list = groups[k];
            int m = list.size();
            int take = Math.min(m, k);
            if (take == 0) continue;

            long sum = 0;
            if (take == m) {
                for (int num : list) {
                    sum += num;
                }
            } else {
                PriorityQueue<Integer> minHeap = new PriorityQueue<>();
                for (int num : list) {
                    if (minHeap.size() < take) {
                        minHeap.offer(num);
                    } else if (num > minHeap.peek()) {
                        minHeap.poll();
                        minHeap.offer(num);
                    }
                }
                while (!minHeap.isEmpty()) {
                    sum += minHeap.poll();
                }
            }
            ans += sum;
        }
        return ans;
    }
}
/*
3645. 最优激活顺序得到的最大总和
https://leetcode.cn/problems/maximum-total-from-optimal-activation-order/description/

第 462 场周赛 T3。

给你两个长度为 n 的整数数组 value 和 limit。
初始时，所有元素都是 非活跃 的。你可以按任意顺序激活它们。
- 要激活一个非活跃元素 i，当前 活跃元素的数量必须 严格小于 limit[i]。
- 当你激活元素 i 时，它的 value[i] 会被加到 总和 中（即所有进行过激活操作的元素 value[i] 之和）。
- 每次激活后，如果 当前 活跃元素的数量变为 x，那么 所有 满足 limit[j] <= x 的元素 j 都会永久变为非活跃状态，即使它们已经处于活跃状态。
返回通过最优选择激活顺序可以获得的 最大总和 。

脑筋急转弯。按 limit 分组后贪心即可。
时间复杂度 O(nlogn)。
 */