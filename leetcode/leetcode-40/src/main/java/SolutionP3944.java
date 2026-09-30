import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolutionP3944 {
    public long minOperations(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }

        List<Integer>[] a = new ArrayList[2];
        Arrays.setAll(a, _ -> new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            a[i % 2].add(nums[i] % k);
        }

        long[] resX = calc(a[0], k);
        long[] resY = calc(a[1], k);

        long min1X = resX[0];
        long min2X = resX[1];
        long bestX = resX[2];

        long min1Y = resY[0];
        long min2Y = resY[1];
        long bestY = resY[2];

        if (bestX != bestY) {
            return min1X + min1Y;
        }
        return Math.min(min1X + min2Y, min2X + min1Y);
    }

    private long[] calc(List<Integer> a, int k) {
        int n = a.size();
        Collections.sort(a);

        long[] b = new long[n * 2];
        for (int i = 0; i < n; i++) {
            b[i] = a.get(i);
            b[n + i] = b[i] + k;
        }

        long[] sum = new long[n * 2 + 1];
        for (int i = 0; i < n * 2; i++) {
            sum[i + 1] = sum[i] + b[i];
        }

        long mn = Long.MAX_VALUE;
        long mn2 = Long.MAX_VALUE;
        long bestX = 0;

        for (int i = 0; i < n; i++) {
            long x = b[i];
            if (i > 0 && b[i] == b[i - 1]) { // 优化：相同的值无需重复计算
                continue;
            }

            long op = calcOp(b, sum, n, k, x);
            // 维护最小次小操作次数
            if (op < mn) {
                mn2 = mn;
                mn = op;
                bestX = x;
            } else if (op < mn2) {
                mn2 = op;
            }
        }

        // 还可以都变成 bestX-1 或者 bestX+1
        long op1 = calcOp(b, sum, n, k, (bestX - 1 + k) % k);
        long op2 = calcOp(b, sum, n, k, (bestX + 1) % k);
        mn2 = Math.min(mn2, Math.min(op1, op2));

        return new long[]{mn, mn2, bestX};
    }

    // 都变成 target 的最小操作次数
    private long calcOp(long[] a, long[] sum, int n, int k, long target) {
        int i = lowerBound(a, -1, n, target);
        int j = lowerBound(a, i - 1, i + n, target + k / 2 + 1);
        return (sum[j] - sum[i]) - (j - i) * target + // [i, j) 中的数都减小到 target
                (n - j + i) * (target + k) - (sum[i + n] - sum[j]); // [j, i+n) 中的数都增大到 target+k
    }

    private int lowerBound(long[] a, int left, int right, long target) {
        while (left + 1 < right) { // 开区间不为空
            int mid = (left + right) >>> 1; // 比 /2 快
            if (a[mid] >= target) {
                right = mid; // 范围缩小到 (left, mid)
            } else {
                left = mid; // 范围缩小到 (mid, right)
            }
        }
        return right;
    }
}
/*
$3944. 使数组变为模交替数组的最少操作次数 II
https://leetcode.cn/problems/minimum-operations-to-make-array-modulo-alternating-ii/description/

给你一个整数数组 nums 和一个整数 k 。
在一步操作中，你可以将 nums 中的任意元素 增加 或 减少 1 。
- 对于每个 偶数 下标 i ，nums[i] % k == x
- 对于每个 奇数 下标 i ，nums[i] % k == y
返回使 nums 成为 模交替 数组所需的 最少 操作次数。
示例 1：
输入： nums = [1,4,2,8], k = 3
输出： 2
示例 2：
输入： nums = [1,1,1], k = 3
输出： 1
示例 3：
输入：nums = [6,7,8], k = 2
输出：0
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
2 <= k <= 10^5

贪心+维护最小次小，O(nlogn) 时间
https://leetcode.cn/problems/minimum-operations-to-make-array-modulo-alternating-ii/solutions/3974557/tan-xin-wei-hu-zui-xiao-ci-xiao-onlogn-s-u5us/
 */