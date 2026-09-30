import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SolutionP4042 {
    // https://leetcode.cn/problems/valid-k-unique-subarrays-ii/solutions/4021291/hua-dong-chuang-kou-yi-huo-ha-xi-pythonj-egme
    private static final Random random = new Random();

    public boolean[] validSubarrays(int[] nums, int k, int l0, int r0, int q) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        Map<Integer, Long> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 把 nums[i] 映射成一个随机的 long
            long randVal = hash.computeIfAbsent(nums[i], _ -> random.nextLong());
            sum[i + 1] = sum[i] ^ randVal;
        }

        int[] l1 = calcLeft(nums, k + 1);
        int[] l2 = calcLeft(nums, k);

        boolean[] ans = new boolean[q];
        int l = l0;
        int r = r0;
        for (int i = 0; i < q; i++) {
            if (i > 0) {
                int g = ans[i - 1] ? l + r : r - l;
                l = (l ^ g) % n;
                r = (r ^ g) % n;
                if (l > r) {
                    int tmp = l;
                    l = r;
                    r = tmp;
                }
            }
            ans[i] = sum[r + 1] == sum[l] && l1[r] <= l && l < l2[r];
        }
        return ans;
    }

    private int[] calcLeft(int[] nums, int k) {
        int n = nums.length;
        int[] lefts = new int[n];
        Map<Integer, Integer> cnt = new HashMap<>();
        int l = 0;
        for (int i = 0; i < n; i++) {
            cnt.merge(nums[i], 1, Integer::sum); // ++cnt[nums[i]]
            while (cnt.size() >= k) {
                int c = cnt.merge(nums[l], -1, Integer::sum); // c = --cnt[nums[l]]
                if (c == 0) {
                    cnt.remove(nums[l]); // 保证 cnt.size() 是窗口内的不同元素个数
                }
                l++;
            }
            lefts[i] = l;
        }
        return lefts;
    }
}
/*
$4042. 有效 K 个不同元素子数组 II
https://leetcode.cn/problems/valid-k-unique-subarrays-ii/description/

给定一个长度为 n 的整数数组 nums 和一个整数 k。
同时给定整数 l0 和 r0，它们定义了第一个查询，以及一个整数 q，表示需要处理的查询总数。
如果一个 子数组 nums[li..ri] 满足以下条件，则称其为 有效 子数组：
- 它恰好包含 k 个不同的数字，并且
- 其中每个不同数字出现的次数都是 偶数。
对于查询 0，令 l0 = l0，r0 = r0。
令 ansi 表示第 i 个查询的结果，其中：
- 如果 nums[li..ri] 是有效子数组，则 ansi = 1；
- 否则 ansi = 0。
对于每个 i > 0，按照以下方式生成下一个查询：
- 如果 ansi-1 = 1，则令 gi-1 = li-1 + ri-1；否则令 gi-1 = ri-1 - li-1。
- 计算 li = (li-1 XOR gi-1) % n，以及 ri = (ri-1 XOR gi-1) % n。
- 如果 li > ri，则交换二者。
返回一个布尔数组 ans，其中 ans[i] 在 ansi = 1 时为 true，否则为 false。
示例 1：
输入： nums = [1,2,2,1], k = 2, l0 = 1, r0 = 2, q = 2
输出： [false,true]
示例 2：
输入： nums = [1,2,3,3,4], k = 1, l0 = 2, r0 = 3, q = 2
输出： [true,false]
提示：
2 <= n == nums.length <= 5 × 10^5
1 <= nums[i] <= 5 × 10^5
1 <= k <= n
0 <= l0 < r0 <= n - 1
1 <= q <= 5 × 10^5
 */