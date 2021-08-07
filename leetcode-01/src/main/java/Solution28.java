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
https://leetcode-cn.com/problems/implement-strstr/

KMP 模板题。
时间复杂度 O(n+m)
空间复杂度 O(m)

扩展: Boyer-Moore 算法、Sunday 算法
官方题解 https://leetcode-cn.com/problems/implement-strstr/solution/
 */