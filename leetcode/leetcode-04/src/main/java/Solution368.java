import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        // 定义 g[i] 为记录 f[i] 是由哪个下标的状态转移而来，如果 f[i]=f[j]+1, 则有 g[i]=j。
        int[] f = new int[n], g = new int[n];
        for (int i = 0; i < n; i++) {
            // 至少包含自身一个数，因此起始长度为 1，由自身转移而来
            int len = 1, pre = i;
            // 如果能接在更长的序列后面，则更新「最大长度」&「从何转移而来」 找出 g[i] 的最大值
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    // 如果能接在更长的序列后面，则更新「最大长度」&「从何转移而来」
                    if (len < f[j] + 1) {
                        len = f[j] + 1;
                        pre = j;
                    }
                }
            }
            // 记录「最终长度」&「从何转移而来」
            f[i] = len;
            g[i] = pre;
        }

        // 遍历所有的 f[i]，取得「最大长度」和「对应下标」
        int max = 0, maxId = 0;
        for (int i = 0; i < n; i++) {
            if (max < f[i]) {
                max = f[i];
                maxId = i;
            }
        }
        List<Integer> resList = new ArrayList<>();
        while (resList.size() != max) {
            resList.add(nums[maxId]);
            maxId = g[maxId];
        }
        return resList;
    }
}
/*
368. 最大整除子集
https://leetcode.cn/problems/largest-divisible-subset/

给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
- answer[i] % answer[j] == 0 ，或
- answer[j] % answer[i] == 0
如果存在多个有效解子集，返回其中任何一个均可。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 10^9
nums 中的所有整数 互不相同

序列 DP + 记录转移关系 倒推答案
https://leetcode.cn/problems/largest-divisible-subset/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-0a3jc/
时间复杂度 O(n^2)
 */