import java.util.HashMap;
import java.util.Map;

public class Solution3395 {
    static final int MOD = (int) (1e9 + 7);

    public int subsequencesWithMiddleMode(int[] nums) {
        int n = nums.length;
        long ans = (long) n * (n - 1) * (n - 2) * (n - 3) * (n - 4) / 120; // 所有方案数
        Map<Integer, Integer> suf = new HashMap<>();
        for (int x : nums) {
            suf.merge(x, 1, Integer::sum); // suf[x]++
        }
        Map<Integer, Integer> pre = new HashMap<>(suf.size()); // 预分配空间
        // 枚举 x，作为子序列正中间的数
        for (int left = 0; left < n - 2; left++) {
            int x = nums[left];
            suf.merge(x, -1, Integer::sum); // suf[x]--
            if (left > 1) {
                int right = n - 1 - left;
                int preX = pre.getOrDefault(x, 0);
                int sufX = suf.get(x);
                // 不合法：只有一个 x
                ans -= (long) comb2(left - preX) * comb2(right - sufX);
                // 不合法：只有两个 x，且至少有两个 y（y != x）
                for (Map.Entry<Integer, Integer> e : suf.entrySet()) {
                    int y = e.getKey();
                    if (y == x) {
                        continue;
                    }
                    int sufY = e.getValue(); // 注意 sufY 可能是 0
                    int preY = pre.getOrDefault(y, 0);
                    // 左边有两个 y，右边有一个 x，即 yy x xz（z 可以等于 y）
                    ans -= (long) comb2(preY) * sufX * (right - sufX);
                    // 右边有两个 y，左边有一个 x，即 zx x yy（z 可以等于 y）
                    ans -= (long) comb2(sufY) * preX * (left - preX);
                    // 左右各有一个 y，另一个 x 在左边，即 xy x yz（z != y）
                    ans -= (long) preY * sufY * preX * (right - sufX - sufY);
                    // 左右各有一个 y，另一个 x 在右边，即 zy x xy（z != y）
                    ans -= (long) preY * sufY * sufX * (left - preX - preY);
                }
            }
            pre.merge(x, 1, Integer::sum); // pre[x]++
        }
        return (int) (ans % MOD);
    }

    private int comb2(int num) {
        return num * (num - 1) / 2;
    }
}
/*
3395. 唯一中间众数子序列 I
https://leetcode.cn/problems/subsequences-with-a-unique-middle-mode-i/description/

第 146 场双周赛 T4。

给你一个整数数组 nums ，请你求出 nums 中大小为 5 的 子序列 的数目，它是 唯一中间众数序列 。
由于答案可能很大，请你将答案对 10^9 + 7 取余 后返回。
众数 指的是一个数字序列中出现次数 最多 的元素。
如果一个数字序列众数只有一个，我们称这个序列有 唯一众数 。
一个大小为 5 的数字序列 seq ，如果它中间的数字（seq[2]）是唯一众数，那么称它是 唯一中间众数 序列。
提示：
5 <= nums.length <= 1000
-10^9 <= nums[i] <= 10^9

枚举。
时间复杂度 O(n^2)
https://leetcode.cn/problems/subsequences-with-a-unique-middle-mode-i/solutions/3026877/zheng-nan-ze-fan-fen-lei-tao-lun-qian-ho-f7cd/
rating 2818 (clist.by)
 */