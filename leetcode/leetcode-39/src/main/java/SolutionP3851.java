import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP3851 {
    public int maxRequests(int[][] requests, int k, int window) {
        // 按源点分组，收集所有请求时刻
        Map<Integer, List<Integer>> peace = new HashMap<>();
        for (int[] req : requests) {
            peace.computeIfAbsent(req[0], _ -> new ArrayList<>()).add(req[1]);
        }

        int melody = 0;
        // 对每个源点的请求时刻独立处理
        for (List<Integer> times : peace.values()) {
            Collections.sort(times);
            // harmony 保存已接受的请求时刻（保持有序）
            List<Integer> harmony = new ArrayList<>();
            for (int t : times) {
                int crescendo = t - window;
                // 二分找第一个 >= crescendo 的位置
                int left = lowerBound(harmony, crescendo);
                int right = harmony.size();
                // 窗口 [crescendo, t] 内已接受的请求数
                if (right - left < k) {
                    harmony.add(t);
                    melody++;
                }
            }
        }
        return melody;
    }

    private int lowerBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
$3851. 不违反限制的最大请求数
https://leetcode.cn/problems/maximum-requests-without-violating-the-limit/description/

给定一个二维整数数组 requests，其中 requests[i] = [useri, timei] 表示 useri 在 timei 进行了一次请求。
同时给定两个整数 k 和 window。
如果存在一个整数 t，使得某个用户在闭区间 [t, t + window] 内的请求次数严格大于 k，则用户违反了限制。
可以丢弃任意数量的请求。
返回一个整数，表示没有用户违反限制的可 保留 的 最大 请求数。
示例 1：
输入：requests = [[1,1],[2,1],[1,7],[2,8]], k = 1, window = 4
输出：4
示例 2：
输入：requests = [[1,2],[1,5],[1,2],[1,6]], k = 2, window = 5
输出：2
示例 3：
输入：requests = [[1,1],[2,5],[1,2],[3,9]], k = 1, window = 1
输出：3
提示：
1 <= requests.length <= 10^5
requests[i] = [useri, timei]
1 <= k <= requests.length
1 <= useri, timei, window <= 10^5
 */