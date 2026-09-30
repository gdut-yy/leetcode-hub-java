import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class SolutionP3991 {
    // https://leetcode.cn/problems/sort-array-using-prefix-reversals/solutions/3995580/zi-fu-chuan-qie-pian-bao-li-bian-li-13xi-dmq1/
    public int sortArray(int[] nums, int[] pre) {
        StringBuilder sb = new StringBuilder();
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int v : sorted) {
            sb.append(v);
        }
        String target = sb.toString();
        sb.setLength(0);
        for (int v : nums) {
            sb.append(v);
        }
        String start = sb.toString();
        if (start.equals(target)) {
            return 0;
        }

        // 可以原地修改 pre（去掉 1：翻转长度为 1 是无效操作）
        Set<Integer> lens = new HashSet<>();
        for (int v : pre) {
            if (v != 1) {
                lens.add(v);
            }
        }

        Queue<String> queue = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        queue.offer(start);
        seen.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int t = 0; t < sz; t++) {
                String a = queue.poll();
                if (a.equals(target)) {
                    return step;
                }
                for (int i : lens) {
                    StringBuilder nxt = new StringBuilder(a);
                    reverse(nxt, 0, i - 1);
                    String ns = nxt.toString();
                    if (seen.add(ns)) {
                        queue.offer(ns);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private void reverse(StringBuilder sb, int from, int to) {
        while (from < to) {
            char c = sb.charAt(from);
            sb.setCharAt(from, sb.charAt(to));
            sb.setCharAt(to, c);
            from++;
            to--;
        }
    }
}
/*
$3991. 使用前缀反转对数组进行排序
https://leetcode.cn/problems/sort-array-using-prefix-reversals/description/

给你一个长度为 n 的整数数组 nums，其中 nums 是区间 [0, n - 1] 内整数的一个 排列。
另给你一个整数数组 pre，其中每个 pre[i] 都是一个合法的 前缀 长度。
一次操作中，你可以从 pre 中选择任意一个长度 x，并将 nums 的前 x 个元素翻转。
例如，对数组 [4, 1, 2, 3] 执行一次长度为 3 的前缀翻转后，结果为 [2, 1, 4, 3]。
返回将 nums 按升序排序所需的最少操作次数。如果无法完成排序，则返回 -1。
示例 1：
输入： nums = [2,0,1], pre = [2,3]
输出： 2
解释：
先翻转前 pre[1] = 3 个元素，得到 nums = [1, 0, 2]。
然后翻转前 pre[0] = 2 个元素，得到 nums = [0, 1, 2]。
因此，将数组排序所需的最少前缀翻转次数为 2。
示例 2：
输入： nums = [1,0,2], pre = [1,3]
输出： -1
解释：
无法仅使用给定的前缀长度对数组进行排序，因此答案为 -1。
示例 3：
输入： nums = [0,1], pre = [2]
输出： 0
解释：
由于 nums 已经按升序排列，因此无需进行任何前缀翻转操作，答案为 0。
约束条件：
1 <= n == nums.length <= 8
0 <= nums[i] <= n - 1
1 <= pre.length <= n
1 <= pre[i] <= n
nums 是由 0 到 n - 1 所有整数组成的一个排列。
pre 中的所有整数 互不相同。
 */