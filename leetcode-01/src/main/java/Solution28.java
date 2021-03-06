public class Solution28 {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * Knuth-Morris-Pratt 算法
     *
     * @param haystack 给定字符串
     * @param needle   目标字符串
     * @return 目标字符串首次出现的下标值
     */
    public int strStr2(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        // 当 needle 是空字符串时我们应当返回 0。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
        if (needleLen == 0) {
            return 0;
        }

        int[] pi = new int[needleLen];
        for (int i = 1, j = 0; i < needleLen; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < haystackLen; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needleLen) {
                return i - needleLen + 1;
            }
        }
        // 如果不存在，则返回 -1
        return -1;
    }
}
/*
28. 实现 strStr()
https://leetcode.cn/problems/implement-strstr/

实现 strStr() 函数。
给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
说明：
当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
提示：
0 <= haystack.length, needle.length <= 5 * 10^4
haystack 和 needle 仅由小写英文字符组成

KMP 模板题。
时间复杂度 O(n+m)
空间复杂度 O(m)
扩展: Boyer-Moore 算法、Sunday 算法
官方题解 https://leetcode.cn/problems/implement-strstr/solution/
 */