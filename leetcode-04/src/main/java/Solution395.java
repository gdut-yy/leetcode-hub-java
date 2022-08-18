public class Solution395 {
    public int longestSubstring(String s, int k) {
        int max = 0;
        for (int i = 1; i <= 26; i++) {
            max = Math.max(max, getLen(s, k, i));
        }
        return max;
    }

    // 字符种类数量 typeNum
    private int getLen(String s, int k, int typeNum) {
        int res = 0;
        int tot = 0;
        int less = 0;
        int[] cntArr = new int[26];

        // 滑动窗口
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            int rIdx = s.charAt(right) - 'a';
            cntArr[rIdx]++;
            if (cntArr[rIdx] == 1) {
                tot++;
                less++;
            }
            if (cntArr[rIdx] == k) {
                less--;
            }

            // 左指针右移
            while (tot > typeNum) {
                int lIdx = s.charAt(left) - 'a';
                cntArr[lIdx]--;
                if (cntArr[lIdx] == k - 1) {
                    less++;
                }
                if (cntArr[lIdx] == 0) {
                    tot--;
                    less--;
                }
                left++;
            }
            if (less == 0) {
                res = Math.max(res, right - left + 1);
            }

            // 右指针右移
            right++;
        }
        return res;
    }
}
/*
395. 至少有 K 个重复字符的最长子串
https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/

给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
提示：
1 <= s.length <= 10^4
s 仅由小写英文字母组成
1 <= k <= 10^5

滑动窗口
枚举字符串种类数量 typeNum（1~26），保证滑动窗口内的字符种类数量为 typeNum，余下的问题为判断每个字符个数是否大于等于 k；
用一个整数 lessK 代表当前小于 k 的字符数量，即可在时间复杂度 O(1) 内判断窗口内每个字符个数是否大于等于 k；
时间复杂度 O(n*26)
空间复杂度 O(1) 其中常数为 26
 */