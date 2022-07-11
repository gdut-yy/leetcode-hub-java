import java.util.HashSet;
import java.util.Set;

public class Solution1044 {
    private static final int BASE = 26;
    private static final long MOD1 = 1000000007;
    private static final long MOD2 = 1000000009;
    private int[] nums;

    public String longestDupSubstring(String s) {
        int len = s.length();
        nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = s.charAt(i) - 'a';
        }

        int left = 1;
        int right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(s, mid) == -1) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 长度为 left-1, 起始下标为 idx
        int idx = checkMid(s, left - 1);
        return s.substring(idx, idx + left - 1);
    }

    // 长度为 mid TTTFFF
    private int checkMid(String s, int mid) {
        long hash1 = 0;
        long hash2 = 0;
        for (int i = 0; i < mid; i++) {
            hash1 = (hash1 * BASE + nums[i]) % MOD1;
            hash2 = (hash2 * BASE + nums[i]) % MOD2;
        }

        Set<Long> hashSet = new HashSet<>();
        long hash = hash1 * MOD2 + hash2;
        hashSet.add(hash);

        // 26^mid % mod
        long aL1 = quickPow(BASE, mid, MOD1);
        long aL2 = quickPow(BASE, mid, MOD2);

        // 滑动窗口
        for (int i = 1; i < s.length() - mid + 1; i++) {
            hash1 = (hash1 * BASE - nums[i - 1] * aL1 % MOD1 + MOD1) % MOD1;
            hash1 = (hash1 + nums[i + mid - 1]) % MOD1;

            hash2 = (hash2 * BASE - nums[i - 1] * aL2 % MOD2 + MOD2) % MOD2;
            hash2 = (hash2 + nums[i + mid - 1]) % MOD2;

            hash = hash1 * MOD2 + hash2;
            if (hashSet.contains(hash)) {
                return i;
            }
            hashSet.add(hash);
        }
        return -1;
    }

    // res = a^b % mod
    private long quickPow(long a, long b, long mod) {
        long res = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                res = res * a % mod;
            }
            a = a * a % mod;
            b /= 2;
        }
        return res;
    }
}
/*
1044. 最长重复子串
https://leetcode.cn/problems/longest-duplicate-substring/

给你一个字符串 s ，考虑其所有 重复子串 ：即 s 的（连续）子串，在 s 中出现 2 次或更多次。这些出现之间可能存在重叠。
返回 任意一个 可能具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。
提示：
2 <= s.length <= 3 * 10^4
s 由小写英文字母组成

Rabin-Karp 字符串哈希算法
相似题目: $1062. 最长重复子串
https://leetcode.cn/problems/longest-repeating-substring/
718. 最长重复子数组
https://leetcode.cn/problems/maximum-length-of-repeated-subarray/
 */