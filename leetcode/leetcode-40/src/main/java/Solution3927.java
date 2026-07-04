import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3927 {
    private static final int MX = 100_001;
    private static final List<Integer>[] divisors = new ArrayList[MX];

    static {
        Arrays.setAll(divisors, e -> new ArrayList<>());
        for (int i = 1; i < MX; i++) {
            for (int j = i; j < MX; j += i) { // 枚举 i 的倍数 j
                divisors[j].add(i); // i 是 j 的因子
            }
        }
    }

    public long minArraySum(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum); // cnt[x]++
        }

        long ans = 0;
        // 遍历 cnt 而不是 nums，这样重复元素只会计算一次
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            int x = e.getKey();
            int c = e.getValue();
            for (int d : divisors[x]) { // 从小到大枚举 x 的因子 d
                if (cnt.containsKey(d)) {
                    ans += (long) d * c; // 把 x 变成 d 是最优的
                    break;
                }
            }
        }
        return ans;
    }
}
/*
3927. 可整除替换后的数组最小元素和
https://leetcode.cn/problems/minimize-array-sum-using-divisible-replacements/description/

第 501 场周赛 T3。

给你一个整数数组 nums。
你可以执行以下操作任意多次：
- 选择两个下标 a 和 b，且满足 nums[a] % nums[b] == 0。
- 将 nums[a] 替换为 nums[b]。
返回执行任意次操作后，数组可能得到的 最小 元素和。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

替换成最小的因子 https://leetcode.cn/problems/minimize-array-sum-using-divisible-replacements/solutions/3966168/ti-huan-cheng-zui-xiao-de-yin-zi-pythonj-ltih/
时间复杂度：O(nA)，其中 n 是 nums 的长度，A≤128 是 nums[i] 的最大因子个数。
 */