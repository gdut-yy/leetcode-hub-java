public class Solution3666 {
    public int minOperations(String s, int k) {
        int n = s.length();
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                c++;
            }
        }
        if (c == 0) {
            return 0;
        }
        if (k % 2 == 0 && c % 2 != 0) {
            return -1;
        }
        if (k == n) {
            return c == n ? 1 : -1;
        }

        int m0 = (c + k - 1) / k;
        int step = 1;
        if (k % 2 == 1) {
            if (m0 % 2 != c % 2) {
                m0++;
            }
            step = 2;
        }

        long m = m0;
        while (true) {
            if (m % 2 == 1) {
                if (m * k <= (long) n * (m - 1) + c) {
                    return (int) m;
                }
            } else {
                if (m * k <= (long) n * m - c) {
                    return (int) m;
                }
            }
            m += step;
        }
    }
}
/*
3666. 使二进制字符串全为 1 的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-equalize-binary-string/description/

第 164 场双周赛 T4。

给你一个二进制字符串 s 和一个整数 k。
在一次操作中，你必须选择 恰好 k 个 不同的 下标，并将每个 '0' 翻转 为 '1'，每个 '1' 翻转为 '0'。
返回使字符串中所有字符都等于 '1' 所需的 最少 操作次数。如果不可能，则返回 -1。
提示:
1 <= s.length <= 10^5
s[i] 的值为 '0' 或 '1'。
1 <= k <= s.length

数学。
https://chat.deepseek.com/a/chat/s/1a003690-eb28-4cfd-9fa2-594bf43a252e
1. 统计零的个数：首先统计字符串中 '0' 的个数（记为 c）。如果 c 为零，说明字符串已经是全 '1'，直接返回 0。
2. 检查可行性：
  - 如果 k 是偶数且 c 是奇数，直接返回 -1，因为无法通过任何操作次数使所有字符变为 '1'。
  - 如果 k 等于字符串长度 n，只有在 c 等于 n 时返回 1，否则返回 -1。
3. 计算最小操作次数：
  - 计算初始的最小操作次数 m0，即 ceil(c / k)。
  - 如果 k 是奇数，确保 m0 与 c 的奇偶性相同；否则，保持 m0 不变。
  - 从 m0 开始，按照步长（k 为奇数时步长为 2，否则为 1）递增，检查条件是否满足：
    - 如果 m 是奇数，检查 m * k <= n * (m - 1) + c。
    - 如果 m 是偶数，检查 m * k <= n * m - c。
  - 一旦条件满足，返回当前的 m。
时间复杂度 O(n)。
 */