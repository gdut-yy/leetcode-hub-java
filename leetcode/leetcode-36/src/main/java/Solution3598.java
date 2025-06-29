public class Solution3598 {
    public int[] longestCommonPrefix(String[] words) {
        int n = words.length;
        if (n == 1) return new int[1];
        if (n == 2) return new int[2];

        int[] pre = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            pre[i] = getLcpLen(words[i], words[i + 1]);
        }

        int[] L = new int[n - 1];
        L[0] = pre[0];
        for (int i = 1; i < n - 1; i++) {
            L[i] = Math.max(L[i - 1], pre[i]);
        }

        int[] R = new int[n - 1];
        R[n - 2] = pre[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            R[i] = Math.max(R[i + 1], pre[i]);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans[i] = R[1];
            } else if (i == n - 1) {
                ans[i] = L[n - 3];
            } else {
                int max1 = i - 2 >= 0 ? L[i - 2] : 0;
                int max2 = i + 1 <= n - 2 ? R[i + 1] : 0;
                int max3 = getLcpLen(words[i - 1], words[i + 1]);
                ans[i] = Math.max(Math.max(max1, max2), max3);
            }
        }
        return ans;
    }

    private int getLcpLen(String str1, String str2) {
        int minLen = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLen; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return i;
            }
        }
        return minLen;
    }
}
/*
3598. 相邻字符串之间的最长公共前缀
https://leetcode.cn/problems/longest-common-prefix-between-adjacent-strings-after-removals/description/

第 456 场周赛 T2。

给你一个字符串数组 words，对于范围 [0, words.length - 1] 内的每个下标 i，执行以下步骤：
- 从 words 数组中移除下标 i 处的元素。
- 计算修改后的数组中所有 相邻对 之间的 最长公共前缀 的长度。
返回一个数组 answer，其中 answer[i] 是移除下标 i 后，相邻对之间最长公共前缀的长度。如果 不存在 相邻对，或者 不存在 公共前缀，则 answer[i] 应为 0。
字符串的前缀是从字符串的开头开始延伸到任意位置的子字符串。
提示：
1 <= words.length <= 10^5
1 <= words[i].length <= 10^4
words[i] 仅由小写英文字母组成。
words[i] 的长度总和不超过 10^5。

前后缀分解。
时间复杂度 O(L)。其中 L 为 words[i] 的长度总和。
 */