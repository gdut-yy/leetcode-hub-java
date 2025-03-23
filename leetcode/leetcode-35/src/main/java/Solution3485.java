import java.util.Arrays;
import java.util.Comparator;

public class Solution3485 {
    public int[] longestCommonPrefix(String[] words, int k) {
        int n = words.length;
        if (k >= n) return new int[n];

        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparing(i -> words[i]));

        // 计算最大 LCP 长度和次大 LCP 长度，同时记录最大 LCP 来自哪里
        int mx = -1, mx2 = -1, mxI = -1;
        for (int i = 0; i + k - 1 < n; i++) {
            // 排序后，[i, i+k-1] 的 LCP 等于两端点的 LCP
            int lcp = calcLCP(words[ids[i]], words[ids[i + k - 1]]);
            if (lcp > mx) {
                mx2 = mx;
                mx = lcp;
                mxI = i;
            } else if (lcp > mx2) {
                mx2 = lcp;
            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, mx); // 先初始化成最大 LCP 长度
        // 移除下标在 idx[mxI, mxI+k-1] 中的字符串，会导致最大 LCP 变成次大 LCP
        for (int i = mxI; i < mxI + k; i++) {
            ans[ids[i]] = mx2; // 改成次大 LCP 长度
        }
        return ans;
    }

    // 计算 s 和 t 的最长公共前缀（LCP）长度
    private int calcLCP(String s, String t) {
        int len = Math.min(s.length(), t.length());
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return i;
            }
        }
        return len;
    }
}
/*
3485. 删除元素后 K 个字符串的最长公共前缀
https://leetcode.cn/problems/longest-common-prefix-of-k-strings-after-removal/description/

第 152 场双周赛 T3。

给你一个字符串数组 words 和一个整数 k。
对于范围 [0, words.length - 1] 中的每个下标 i，在移除第 i 个元素后的剩余数组中，找到任意 k 个字符串（k 个下标 互不相同）的 最长公共前缀 的 长度。
返回一个数组 answer，其中 answer[i] 是 i 个元素的答案。如果移除第 i 个元素后，数组中的字符串少于 k 个，answer[i] 为 0。
一个字符串的 前缀 是一个从字符串的开头开始并延伸到字符串内任何位置的子字符串。
一个 子字符串 是字符串中一段连续的字符序列。
提示：
1 <= k <= words.length <= 10^5
1 <= words[i].length <= 10^4
words[i] 由小写英文字母组成。
words[i].length 的总和小于等于 10^5。

任意 k 个 -> 连续 k 个
1. 排序，那么只需要考虑长为 k 的连续子数组的 LCP
2. 排序后，子数组的 LCP = LCP(子数组第一个字符串，子数组最后一个字符串)
   把 k 个字符串的问题转换成 2 个字符串的问题
3. 如果不删除，那么答案是多少？
   暴力枚举所有长为 k 的子数组，根据 (2)，
   计算所有 LCP(words[i], words[i+k-1])，取最大值，即为不删除时的答案
4. 记录最大的 LCP 对应的子数组是 [mx_i, mx_{i+k-1}]
   记录次大的 LCP 对应的子数组是 [mx2_i, mx2_{i+k-1}]
5. 考虑删除一个字符串
   分类讨论：
   a. 如果删除的字符串不在 [mx_i, mx_{i+k-1}] 中，那么答案就是不删除时的答案，即最大 LCP
   剩下的问题就是删除在 [mx_i, mx_{i+k-1}] 中的字符串
   b. 如果删除的字符串不在 [mx2_i, mx2_{i+k-1}] 中，那么答案就是次大的 LCP
   c. 如果删除的字符串在 [mx_i, mx_{i+k-1}] 中，又在 [mx2_i, mx2_{i+k-1}] 中，那么答案是多少？
   意味着这两个数组是重叠的，重叠的字符串（也就是我们删除的字符串 s）即有最大的 LCP 又有次大 LCP
   围绕重叠的字符串讨论，那么次大 LCP 也是 LCP 的前缀
   去掉字符串 s，可以再加一个交集中的其他字符串进来，仍然是 k 个字符串，且次大 LCP 是不变的
   那么答案就是次大的 LCP
rating 2269 (clist.by)
 */
