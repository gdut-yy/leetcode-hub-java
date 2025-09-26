import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3691 {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        SparseTable st = new SparseTable(nums);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o[0])); // 最大堆
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{st.query(i, n - 1), i, n - 1}); // 子数组值，左端点，右端点加一
        }

        long ans = 0;
        while (k-- > 0 && pq.peek()[0] > 0) {
            int[] top = pq.poll();
            ans += top[0];
            top[2]--;
            top[0] = st.query(top[1], top[2]);
            pq.add(top);
        }
        return ans;
    }

    static class SparseTable {
        long[][] mx, mi;
        int[] logTable;

        public SparseTable(int[] arr) {
            int n = arr.length;
            int maxLog = log2(n) + 1;
            mx = new long[n][maxLog];
            mi = new long[n][maxLog];
            logTable = new int[n + 1];
            // 预处理对数表
            for (int i = 2; i <= n; ++i) {
                logTable[i] = logTable[i / 2] + 1;
            }
            // 初始化 ST 表
            for (int i = 0; i < n; ++i) {
                mx[i][0] = arr[i];
                mi[i][0] = arr[i];
            }
            // 动态规划填充表
            for (int j = 1; (1 << j) <= n; ++j) {
                for (int i = 0; i + (1 << j) <= n; ++i) {
                    mx[i][j] = Math.max(mx[i][j - 1], mx[i + (1 << (j - 1))][j - 1]);
                    mi[i][j] = Math.min(mi[i][j - 1], mi[i + (1 << (j - 1))][j - 1]);
                }
            }
        }

        // ceil(log2(x)) = 32 - numberOfLeadingZeros(x - 1)
        int log2(long x) {
            return 64 - Long.numberOfLeadingZeros(x - 1);
        }

        long query_max(int l, int r) {
            int j = logTable[r - l + 1];
            return Math.max(mx[l][j], mx[r - (1 << j) + 1][j]);
        }

        long query_min(int l, int r) {
            int j = logTable[r - l + 1];
            return Math.min(mi[l][j], mi[r - (1 << j) + 1][j]);
        }

        int query(int l, int r) {
            return (int) (query_max(l, r) - query_min(l, r));
        }
    }
}
/*
3691. 最大子数组总值 II
https://leetcode.cn/problems/maximum-total-subarray-value-ii/description/

第 468 场周赛 T4。

给你一个长度为 n 的整数数组 nums 和一个整数 k。
你必须从 nums 中选择 恰好 k 个 不同 的非空子数组 nums[l..r]。子数组可以重叠，但同一个子数组（相同的 l 和 r）不能 被选择超过一次。
子数组 nums[l..r] 的 值 定义为：max(nums[l..r]) - min(nums[l..r])。
总值 是所有被选子数组的 值 之和。
返回你能实现的 最大 可能总值。
子数组 是数组中连续的 非空 元素序列。
提示:
1 <= n == nums.length <= 5 * 10^4
0 <= nums[i] <= 10^9
1 <= k <= min(10^5, n * (n + 1) / 2)

ST 表 + 最大堆
https://leetcode.cn/problems/maximum-total-subarray-value-ii/solutions/3787892/st-biao-zui-da-dui-pythonjavacgo-by-endl-igja/
 */