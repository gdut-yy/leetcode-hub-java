import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionP3520 {
    public int minThreshold(int[] nums, int k) {
        int mx = Arrays.stream(nums).max().orElseThrow();
        int mn = Arrays.stream(nums).min().orElseThrow();
        int t = mx - mn;

        int left = 0;
        int right = t + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left == t + 1 ? -1 : left;
    }

    private boolean checkMid(int[] nums, int k, int mid) {
        int[] yArr = getDiscrete(nums, mid);
        int m = yArr.length;
        // 离散化结束

        BIT tr = new BIT(m);
        int ans = 0;
        for (int x : nums) {
            ans += tr.query(getId(yArr, x + mid)) - tr.query(getId(yArr, x));
            tr.add(getId(yArr, x), 1);
        }
        return ans >= k;
    }

    private int[] getDiscrete(int[] xArr, int mid) {
        Set<Integer> set = new HashSet<>();
        for (int x : xArr) {
            set.add(x);
            set.add(x + mid);
        }
        int sz = set.size();
        int[] yArr = new int[sz];
        int id = 0;
        for (Integer x : set) yArr[id++] = x;
        Arrays.sort(yArr);
        return yArr;
    }

    private int getId(int[] yArr, int x) {
        return Arrays.binarySearch(yArr, x) + 1;
    }

    static class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int pos, int val) {
            for (; pos <= n; pos += lb(pos)) tree[pos] += val;
        }

        int query(int pos) {
            int ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
            return ret;
        }
    }
}
/*
$3520. 逆序对计数的最小阈值
https://leetcode.cn/problems/minimum-threshold-for-inversion-pairs-count/description/

给定一个整数数组 nums 和一个整数 k。
阈值 为 x 的逆序对是一对下标 (i, j) 满足：
- i < j
- nums[i] > nums[j]
- 两个数字的差 最多为 x（即 nums[i] - nums[j] <= x）。
你的任务是确定最小的整数 min_threshold，使得 至少 有 k 个逆序对的阈值是 min_threshold。
如果没有这样的整数，返回 -1。
提示：
1 <= nums.length <= 10^4
1 <= nums[i] <= 10^9
1 <= k <= 10^9

离散化 + 二分答案。
https://leetcode.cn/problems/minimum-threshold-for-inversion-pairs-count/solutions/3653160/er-fen-shu-zhuang-shu-zu-by-13126731116-c9dh/
 */