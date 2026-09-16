import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution4053 {
    private static final List<Long> ODD = new ArrayList<>();
    private static final List<Long> EVEN = new ArrayList<>();

    static {
        for (int len = 1; len <= 10; len++) {
            int half = (len + 1) / 2;
            long start = 1;
            for (int i = 1; i < half; i++) start *= 10;
            long end = start * 10;
            for (long prefix = start; prefix < end; prefix++) {
                String s = Long.toString(prefix);
                String rev = new StringBuilder(s.substring(0, len / 2)).reverse().toString();
                long palindrome = Long.parseLong(s + rev);
                if ((palindrome & 1) == 0) EVEN.add(palindrome);
                else ODD.add(palindrome);
            }
        }
        Collections.sort(ODD);
        Collections.sort(EVEN);
    }

    public long minOperations(int[] nums) {
        long ans = 0;
        for (int num : nums) {
            List<Long> palindromes = (num & 1) == 0 ? EVEN : ODD;
            ans += nearest(palindromes, num);
        }
        return ans;
    }

    private long nearest(List<Long> palindromes, long num) {
        int idx = searchInts(palindromes, num);
        long best = Long.MAX_VALUE;
        if (idx < palindromes.size()) best = Math.min(best, palindromes.get(idx) - num);
        if (idx > 0) best = Math.min(best, num - palindromes.get(idx - 1));
        return best / 2;
    }

    private int searchInts(List<Long> a, long key) {
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
4053. 使每个元素变为回文数的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-make-every-element-palindromic/description/

第 519 场周赛 T2。

给你一个整数数组 nums。
一次 操作 中，你可以选择一个下标 i，并将 nums[i] 增加 2 或减少 2。
返回将 nums 中的每个元素都变为 正回文整数 所需的 最少 操作次数。不同元素可以变成不同的回文整数。
如果一个整数正着读和反着读都相同，则称其为 回文整数 。例如，121 是回文整数，而 123 不是。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

预处理 + 二分。
时间复杂度 O(nlogU)。
相似题目: 3766. 将数字变成二进制回文数的最少操作
https://leetcode.cn/problems/minimum-operations-to-make-binary-palindrome/description/
 */